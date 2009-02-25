export OE_HOME=$HOME/beagle/oe
export MY_OE_CONF="beagleboard"
export BBPATH=$OE_HOME/org.beagleboard.dev/:$OE_HOME/org.beagleboard.dev/$MY_OE_CONF:$OE_HOME/org.openembedded.dev
export BBFILES="$OE_HOME/org.openembedded.dev/packages/*/*.bb $OE_HOME/local/packages/*/*.bb"
export PATH=$OE_HOME/opt/bitbake/bin:$PATH
if [ "$PS1" ]; then
   if [ "$BASH" ]; then
     export PS1="\[\033[01;32m\]OE:$MY_OE_CONF\[\033[00m\] ${PS1}"
   fi
fi

