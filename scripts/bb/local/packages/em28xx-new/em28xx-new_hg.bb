DESCRIPTION = "em28xx video for linux driver"
HOMEPAGE = "http://mcentral.de/wiki/index.php5/Main_Page"
SECTION = "kernel/modules"
PRIORITY = "optional"
LICENSE = "GPL"

PR = "r1"
PV = "0.0+${SRCREV}"

RRECOMMENDS = "kernel-module-videodev kernel-module-v4l1-compat kernel-module-v4l2-common"

SRCREV = "23b91e50e0e1"
SRC_URI = " \
  hg://mcentral.de/hg/~mrec/;proto=http;module=em28xx-new;rev=${SRCREV} \
  file://Makefile.patch;patch=1 \
  file://remove-dvb-stuff.patch;patch=1 \
"

S = "${WORKDIR}/em28xx-new"

inherit module

do_compile () {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS
        oe_runmake 'KERNELDIR=${STAGING_KERNEL_DIR}' \
                   'CC=${KERNEL_CC}' \
                   'LD=${KERNEL_LD}'
}

do_install() {
        install -d ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/media/video/em28xx
        install -m 0644 *${KERNEL_OBJECT_SUFFIX} ${D}${base_libdir}/modules/${KERNEL_VERSION}/kernel/drivers/media/video/em28xx
}
