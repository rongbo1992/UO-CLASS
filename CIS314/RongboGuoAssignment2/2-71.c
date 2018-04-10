/*
Part A. What is wrong with this code?

The reason why the code are not working very well 
is the code doesn't generate the sign negetive number.


Part B. Give a correct implementation of the function that uses only left and right shifts, along
with one subtraction. 

the code shows below
*/

#include <stdio.h>

typedef unsigned packed_t;

int xbyte(packed_t word, int bytenum){
	int modifiedBytenum = (3 - bytenum);
	return (((int)word << (modifiedBytenum << 3)) >> 24);
}

int main(void){
	packed_t x = 0xFFFFFFFF;

	printf("%d\n", xbyte(x,0));
	printf("%d\n", xbyte(x,1));
	printf("%d\n", xbyte(x,2));
	printf("%d\n", xbyte(x,3));
}