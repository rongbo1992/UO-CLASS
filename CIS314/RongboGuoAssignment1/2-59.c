#include <stdio.h>
#include <inttypes.h>

unsigned combine(unsigned x, unsigned y){
	return (y & 0xffffff00) |(x & 0xff);
}

int main(){

	printf ("%x\n" , combine(0x89ABCDEF,0x76543210));
	return 0;
}