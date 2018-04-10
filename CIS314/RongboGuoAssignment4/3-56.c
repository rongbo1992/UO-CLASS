/*
Rongbo Guo
CIS 314
Assignment 4

Problem 3.56
A.Which registers hold program values x, n, result, and mask? 
answer: x = %esi, n = %ebx, result = %edi, mask = %edx;

B.What are the initial values of result and mask?
answer: result = -1 , musk = 1;

C.What is the test condition for mask?
answer: mask != 0;

D.How does mask get updated? 
answer: mask = mask << n;

E.How does result get updated? 
answer: result ^= mask & x;

F.Fill in all the missing parts of the C code. 
answer: code shows below.
*/

#include <stdio.h>

int loop(int x, int n){
	int result = -1;
	int mask;
	for (mask = 1; mask != 0; mask = mask << n){
		result ^= mask & x;
	}
	return result;
}

int main(void){
	printf("%d\n", loop(16, 4));
}


















