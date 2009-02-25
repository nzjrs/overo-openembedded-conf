#!/bin/bash
KERNEL_DIR=/media/bbkernel
ROOTFS_DIR=/media/bbrootfs
IMAGE=uImage-beagleboard.bin
ROOTFS=console-image-beagleboard.tar

echo "===== BEAGLEBOARD                 ====="

if [ -z $OE_HOME ] ; then
    echo "ERROR: OE environment not found"
    exit 1
fi

export `bitbake -e 2>/dev/null | grep "^DEPLOY_DIR_IMAGE=" | sed 's/"//g'`

if [ -z $DEPLOY_DIR_IMAGE ] ; then
    echo "ERROR: OE deployment dir not found"
    exit 1
fi

if [ ! -d $KERNEL_DIR ] ; then
    echo "ERROR: Kernel partition not found ($KERNEL_DIR)"
    exit 1
fi

if [ ! -d $ROOTFS_DIR ] ; then
    echo "ERROR: Root file system partition not Found ($ROOTFS_DIR)"
    exit 1
fi

MODULES=$DEPLOY_DIR_IMAGE/modules-`readlink $DEPLOY_DIR_IMAGE/$IMAGE | sed 's/uImage-//' | sed 's/.bin//'`.tgz
if [ ! -f $MODULES ] ; then
    echo "ERROR: Kernel modules not found ($MODULES)"
    exit 1
fi

echo "Extract rootfs to $ROOTFS_DIR (Y/N)"
read -n 1 -s ky
if [ "$ky" == "Y" ] ; then
    echo "===== EXTRACTING ROOT FILE SYSTEM ====="
    sudo tar xvf $DEPLOY_DIR_IMAGE/$ROOTFS -C $ROOTFS_DIR > /tmp/extract.log
fi

echo "Extract kernel modules to $ROOTFS_DIR (Y/N)"
read -n 1 -s km
if [ "$km" == "Y" ] ; then
    echo "===== EXTRACTING KERNEL MODULES   ====="
    sudo tar xvzf $MODULES -C $ROOTFS_DIR >> /tmp/extract.log
fi

cp /tmp/extract.log .

echo "Copy kernel to $KERNEL_DIR (Y/N)"
read -n 1 -s rfsy
if [ "$rfsy" == "Y" ] ; then
    echo "===== COPYING KERNEL              ====="
    cp $DEPLOY_DIR_IMAGE/$IMAGE $KERNEL_DIR/uImage
fi

# See
# http://www.angstrom-distribution.org/demo/beagleboard/README.txt
# http://elinux.org/BeagleBoardNAND

echo "Download MLO and copy to $KERNEL_DIR (Y/N)"
read -n 1 -s mlo
if [ "$mlo" == "Y" ] ; then
    echo "===== DOWNLOADING MLO             ====="
    wget -q http://www.angstrom-distribution.org/demo/beagleboard/MLO -O $KERNEL_DIR/mlo
    wget -q http://www.angstrom-distribution.org/demo/beagleboard/x-load.bin.ift -O $KERNEL_DIR/x-load.bin.ift
fi

echo "Download u-boot and copy to $KERNEL_DIR (Y/N)"
read -n 1 -s ubt
if [ "$ubt" == "Y" ] ; then
    echo "===== DOWNLOADING UBOOT           ====="
    wget -q http://www.angstrom-distribution.org/demo/beagleboard/u-boot.bin -O $KERNEL_DIR/u-boot.bin
    wget -q http://www.angstrom-distribution.org/demo/beagleboard/README.txt -O $KERNEL_DIR/README.txt
fi





echo "===== UNMOUNTING ROOT FILE SYSTEM ====="
sudo umount $ROOTFS_DIR
echo "===== UNMOUNTING KERNEL           ====="
sudo umount $KERNEL_DIR

