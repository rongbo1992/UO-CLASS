#include <stdio.h>

int any_odd_one(unsigned x){
	return (x & 0xAAAAAAAA)!=0;
}

int main(){
	printf ("It should be 0, the output: %x\n", any_odd_one(0x1));
	printf ("It should be 1, the output: %x\n", any_odd_one(0x2));
}