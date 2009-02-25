DESCRIPTION = "Modified emb28xx video driver"
HOMEPAGE = "http://tldp.org/LDP/lkmpg/2.6/html/hello2.html"
SECTION = "kernel/modules"
PRIORITY = "optional"
LICENSE = "GPL"
PR = "r1"

SRC_URI = "                 \
  file://em28xx-audio.c     \
  file://em28xx.h           \
  file://em28xx-keymaps.c   \
  file://em28xx-webcam.c    \
  file://em28xx-cards.c     \
  file://em28xx-i2c.c       \
  file://em28xx-keymaps.h   \
  file://em28xx-core.c      \
  file://em28xx-input.c     \
  file://em28xx-video.c     \
  file://Makefile           \
"

S = "${WORKDIR}"

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
