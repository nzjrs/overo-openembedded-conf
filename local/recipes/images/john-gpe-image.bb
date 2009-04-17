inherit image

DEPENDS = "task-base"

IMAGE_LINGUAS = ""

APPS = " \
  simple-video-viewer \
  opencvtest \
  simplehelloworld \
  firefly-mv-utils \
  iozone3 \
  latencytop \
  opencv \
"

IMAGE_INSTALL += " \
  ${XSERVER} \
  ${APPS} \
  task-base-extended \
  task-proper-tools \
  angstrom-x11-base-depends \
  gpe-dm \
  x11-session-scripts \
  matchbox-wm \
  xterm \
"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

