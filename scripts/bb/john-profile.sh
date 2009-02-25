export OE_HOME=$HOME/beagle/oe
export BBPATH=$OE_HOME/local:$OE_HOME/org.openembedded.dev
export PATH=$OE_HOME/opt/bitbake/bin:$PATH

export BB_ENV_EXTRAWHITE="OE_HOME"

if [ "$PS1" ]; then
   if [ "$BASH" ]; then
     export PS1="\[\033[01;32m\]OE:beagleboard\[\033[00m\] ${PS1}"
   fi
fi

