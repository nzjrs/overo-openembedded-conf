#!/bin/sh
HERE="$HOME/overo-oe/sources/"
THERE="git@open.grcnz.com:/mnt/datadisk/openembedded/"

rsync -rlptDP $HERE $THERE
rsync -rlptDP $THERE $HERE
