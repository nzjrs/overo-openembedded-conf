inherit image

#export IMAGE_BASENAME = "minimalist-gpe-image"

#PR = "r2"

DEPENDS = "task-boot"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-boot \
    gpe-dm gpe-session-scripts gpe-login \
    matchbox-wm \
    gpe-terminal \
"

ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"


