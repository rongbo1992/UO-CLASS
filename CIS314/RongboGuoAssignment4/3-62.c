/*
Rongbo Guo
CIS 314
Assignment 4

A.What is the value of M?
answer:Because we need to go 52 bytes and each element have 4 bytes, 
M = 52 /4 = 13. 

B.What registers hold program values i and j ? 
answer: edi and ecx hold i and j

C.Write a C code version of transpose that makes use of the optimizations that occur in
this loop. Use the parameter M in your code rather than numeric constants. 
answer: code shows below
*/

#include <stdio.h>
#define M 5

typedef int Marray_t[5][5];

void transpose(Marray_t Array){
	int i, j;
	int *x = Array[0];
	for (i = 0; i < M; i++){
		int *y = &Array[0] [i];
		for(j = 0; j<i; j++){
			int var = x[j];
			x[j] = *y;
			*y = var;
			y += M;
		}
		x += M;
	}
}

void showMatrix(Marray_t Array){
	for(int i = 0; i<M; i++){
		for(int j = 0; j<5; j++){
			printf("%x\n", Array[i][j]);
		}
	}
}



int main(){
	Marray_t Array = {{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5},{1,2,3,4,5}};
	transpose(Array);
	showMatrix(Array);
}












