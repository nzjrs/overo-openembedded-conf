#include <stdio.h>
#include <stdint.h>
#include "i2c-dev.h"
#include <fcntl.h>
#include <sys/ioctl.h>
#include <unistd.h>
#include <errno.h>
#include <stdlib.h>
#include <string.h>

#define ADDRESS 0x3f

typedef enum
{
	FALSE = 0, TRUE
} bool;

bool err_enable = TRUE;

void putstr( int fd, char* s )
{
	for(;*s!='\0';s++)
	{
		int r;
		r = i2c_smbus_write_byte_data( fd, 10, *s );
		if( r < 0 )
			fprintf(stderr, "Failed to read dio pins\n");
	}
}

int main( int argc, char** argv )
{
	int r;
	uint8_t setting;
	int fd;

	fd = open( "/dev/i2c-1", O_RDWR );

	if( fd == -1 )
	{
		fprintf( stderr, "Failed to open /dev/i2c-1: %m\n" );
		return 1;
	}

	if( ioctl( fd, I2C_SLAVE, ADDRESS ) < 0 )
	{
		fprintf( stderr, "Failed to set slave address: %m\n" );
		return 2;
	}

	if( ioctl( fd, I2C_PEC, 1) < 0)
	{
		fprintf( stderr, "Failed to enable PEC\n");
		return 3;
	}

	putstr( fd, "Hello there Tom.  The PEC is now on!" );
	
	return 0;
}

