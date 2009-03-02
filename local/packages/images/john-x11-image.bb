#Angstrom X11 image
#
#ANGSTROM_EXTRA_INSTALL += " \
#                           ${@base_contains("MACHINE_FEATURES", "phone", "openmoko-dialer2", "",d)} \
#			  " 
#XSERVER ?= "xserver-kdrive-fbdev"
#
#export IMAGE_BASENAME = "x11-image"
#
#DEPENDS = "task-base"
#IMAGE_INSTALL = "\
#    ${XSERVER} \
#    task-base-extended \
#    angstrom-x11-base-depends \
#    angstrom-gpe-task-base \
#    angstrom-gpe-task-settings \
#    ${ANGSTROM_EXTRA_INSTALL}"
#
#IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"
#
##zap root password for release images
#ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
#
#inherit image

# Demo image for beagleboard

XSERVER = "xserver-xorg \
           xf86-input-evdev \
           xf86-input-mouse \
           xf86-video-fbdev \
           xf86-input-keyboard \
"

export IMAGE_BASENAME = "albatross-x11-image"

DEPENDS = "task-base"
IMAGE_INSTALL = "\
    ${XSERVER} \
    task-base-extended \
    angstrom-x11-base-depends \
## The following packages are taken from angstrom-gpe-task-base
    angstrom-gpe-task-base \
#    gpe-scap \
#    matchbox \
#    matchbox-panel-hacks \
#    matchbox-applet-startup-monitor \
#    xcursor-transparent-theme \
#    rxvt-unicode \
#    gpe-terminal \
#    matchbox-keyboard \
#    xkbd \
#    xkbd-layout-ru \
#    gpe-theme-clearlooks \
#    xst \
#    xhost \
#    xrdb \
#    gpe-soundserver \
#    gpe-dm \
#    gpe-login \
#    gpe-session-scripts \
#    gpe-icons \
#    gpe-confd \
#    gpe-autostarter \
#    ${@base_contains("MACHINE_FEATURES", "touchscreen", "libgtkstylus", "",d)} \
#    ${@base_contains("MACHINE_FEATURES", "keyboard", "", "libgtkinput",d)} \
#    suspend-desktop \
#    teleport \
#    xauth \
#    gdk-pixbuf-loader-png \
#    gdk-pixbuf-loader-xpm \
#    gdk-pixbuf-loader-jpeg \
#    pango-module-basic-x \
#    pango-module-basic-fc \
#    ${@base_contains("COMBINED_FEATURES", "bluetooth", "gpe-bluetooth", "",d)} \
#    ${@base_contains("COMBINED_FEATURES", "bluetooth", "bluez-gnome", "",d)} \
## The following packages are taken from angstrom-gpe-task-settings
    angstrom-gpe-task-settings \
#    matchbox-panel-manager \
#    mboxkbd-layouts-gui \
#    gpe-su \
#    gpe-conf \
#    gpe-package \
#    gpe-shield \
#    gpe-taskmanager \
#    keylaunch \
#    minilite \
#    minimix \
#    xmonobut"
## The following were manually added to x11-image
#    angstrom-zeroconf-audio \
#    angstrom-led-config \ 
#	gpe-scap \
#    psplash \
#    e-wm exhibit \
#    xterm xmms epiphany-firefox-replacement \
#    swfdec-mozilla \
#    hicolor-icon-theme gnome-icon-theme \
#    jaaa nmap iperf gnuplot \
#    abiword \
##    gnumeric \
##    gimp \
#    powertop oprofile \
#    pidgin \
##    irssi \
#    mplayer omapfbplay \
#    xcalc \
    simple-video-viewer"

IMAGE_PREPROCESS_COMMAND = "create_etc_timestamp"

#zap root password for release images
ROOTFS_POSTPROCESS_COMMAND += '${@base_conditional("DISTRO_TYPE", "release", "zap_root_password; ", "",d)}'
ROOTFS_POSTPROCESS_COMMAND += 'set_image_autologin;'

inherit image
