#!/bin/bash
KERNEL=$(bitbake -e 2>/dev/null | grep "^PREFERRED_PROVIDER_virtual/kernel=" | sed 's/"//g' | cut -f 2 -d =)
bitbake -c menuconfig $KERNEL
