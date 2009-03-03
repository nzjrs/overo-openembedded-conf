inherit image

DEPENDS = "task-base"

IMAGE_LINGUAS = ""

APPS = " \
  simple-video-viewer \
  opencvtest \
  simplehelloworld \
"

IMAGE_INSTALL += " \
  ${XSERVER} \
  ${APPS} \
#  task-boot \
  task-base-extended \
  task-proper-tools \
  angstrom-x11-base-depends \
#  u-boot-tools-env \
#  alsa-utils \
#  alsa-utils-alsactl \
#  alsa-utils-alsamixer \
#  alsa-utils-aplay \
#  bash \
#  bzip2 \
#  dosfstools \
#  e2fsprogs-mke2fs \
#  fbgrab \
#  fbset \
#  fbset-modes \
#  ksymoops \
#  mkfs-jffs2 \
#  mtd-utils \
#  openssh-scp \
#  openssh-ssh \
#  socat \
#  strace \
  gpe-dm \
  gpe-session-scripts \
  gpe-login \
  matchbox-wm \
  gpe-terminal \
#  angstrom-feed-configs \
#  opkg-nogpg opkg-collateral \
#  psplash \
#  xdg-utils \
"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'

