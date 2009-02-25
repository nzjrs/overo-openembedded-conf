require packages/images/console-image.bb

DEPENDS += "task-base"

IMAGE_INSTALL += "\
        opencv-samples      \
        ipkg                \
        em28xx-pollin       \
        kernelhelloworld    \
        i2c-tools           \
        ppz-client          \
"
