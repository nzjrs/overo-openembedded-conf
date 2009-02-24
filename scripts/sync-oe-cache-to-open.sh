#!/bin/sh
HERE="/home/john/overo-oe/sources/"
THERE="john@open.grcnz.com:/mnt/datadisk/openembedded/"

rsync -aP $HERE $THERE
rsync -aP $THERE $HERE
