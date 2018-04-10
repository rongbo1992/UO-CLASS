/*
Rongbo Guo
CIS314
Assignment 3
this program is to translate assembly code to c code.

1 movl 12(%ebp), %edx
2 subl 16(%ebp), %edx
3 movl %edx, %eax
4 sall $31, %eax
5 sarl $31, %eax
6 imull 8(%ebp), %edx
7 xorl %edx, %eax
Parameters x, y, and z are stored at memory locations with offsets 8, 12, and 16 relative
to the address in register %ebp. The code stores the return value in register %eax. 

the code shows below
*/
#include <stdio.h>

 void decode2(int x, int y, int z){
	int edx;
	int eax;
	//movl 12(%edp), %edx
	edx = y;
	printf("Let the edx equal y: %x\n", edx);
	//subl 16(%edp), %edx
	edx = z - edx;
	printf("Let z minus edx: %x\n", edx);
	//movl %edx, %eax
	eax = edx;
	printf("Let the eax equal edx: %x\n", eax);
	//sall $31, %eax
	eax = eax << 31;
	printf("Let eax shift left for 31 bits: %x\n", eax);
	//sarl $31, %eax
	eax = eax >> 31;
	printf("Let eax shift right for 31 bits: %x\n", eax);
	//imull 8(%ebp), %edx
	edx = edx * x;
	printf("Let edx multiply x: %x\n", edx);
	//xorl %edx, %eax
	eax = edx^eax;
	printf("Let edx xorl eax: %x\n", eax);

}

int main(){
	//give one example to test the code we translat.
	int x = 0x5;
	int y = 0x6;
	int z = 0x7;
	decode2(x,y,z);
	printf("out put should be fffffffa");
}











