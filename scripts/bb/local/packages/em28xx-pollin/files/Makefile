em28xx-objs := em28xx-video.o em28xx-i2c.o em28xx-cards.o em28xx-core.o em28xx-input.o em28xx-webcam.o em28xx-keymaps.o

CONFIG_VIDEO_EM28XX:=m
CONFIG_VIDEO_EM28XX_AUDIO:=m

obj-$(CONFIG_VIDEO_EM28XX)		+= em28xx.o
obj-$(CONFIG_VIDEO_EM28XX_AUDIO)	+= em28xx-audio.o

PWD  := $(shell pwd)

default:
	$(MAKE) -C $(KERNELDIR) SUBDIRS=$(PWD) CC=$(CC) modules

clean:
	$(MAKE) -C $(KERNELDIR) SUBDIRS=$(PWD) CC=$(CC) clean
