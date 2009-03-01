#
# Environment setup for oe
#

export BB_ENV_EXTRAWHITE="MACHINE DISTRO ANGSTROM_MODE OVEROTOP OEBRANCH USERBRANCH"

export OVEROTOP="${HOME}/overo-oe"
export OEBRANCH="${OVEROTOP}/org.openembedded.dev"
export USERBRANCH="${OVEROTOP}/local"

export PATH="${OVEROTOP}/bitbake/bin:$PATH"
export BBPATH="${OVEROTOP}/build:${USERBRANCH}:${OEBRANCH}"

if [ "$PS1" ]; then
   if [ "$BASH" ]; then
     export PS1="\[\033[01;32m\]OE:overo\[\033[00m\] ${PS1}"
   fi
fi

umask 0002

#
# end oe setup
#
