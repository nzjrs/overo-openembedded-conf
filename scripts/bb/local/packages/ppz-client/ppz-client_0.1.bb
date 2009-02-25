DESCRIPTION = "PPZ userspace client"

PR = "r0"

DEPENDS = ""

SRC_URI = " \
  file://main.c \
  file://i2c-dev.h \
"

S = "${WORKDIR}"

do_compile () {
    ${CC} ${CFLAGS} ${LDFLAGS} -o ppz-client main.c
}

do_install () {
    install -d ${D}${bindir}/
    install -m 0755 ${S}/ppz-client ${D}${bindir}/
}

FILES_${PN} = "${bindir}/ppz-client"

