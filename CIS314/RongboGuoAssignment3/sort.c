/*
Rongbo Guo
CIS 314
Assignment 3
This program is  about try to writ  a C code which can sort the arry.
*/
#include <stdio.h>
#include <stdlib.h>



int main(){
	//When the program running we need to enter the array length for the array frist,
	//then enter the array we neet to sort.
	printf("Please enter the length of array and arry we will sort in integer: \n");
	int arrayLength;
	scanf("%d\n",&arrayLength);
    
	//allocate the array
	int *array = (int *) malloc(sizeof(int) * arrayLength);
	//printf("Enter %d integers\n", arrayLength);

	//get the array we enter
	for(int i = 0; i < arrayLength; i++){
		scanf("%d" , &array[i]);
	}

	//sort the array 
	//This is one of the way for sort which is bubble sort, it is the 
	//sort to compare each pair of array elements from the beginning of 
	//an array and, if they are in reversed order, swap them. Bubble sort 
	//belongs to O(n2) sorting algorithms.

	for (int c = 0 ; c < ( arrayLength - 1 ); c++){
    	for (int d = 0 ; d < arrayLength - (c + 1); d++){
    		if (array[d] > array[d+1]){
				int swap = array[d];
				array[d]   = array[d+1];
				array[d+1] = swap;
      		}
    	}
  	}


	//print out the array that are already be sorted
	for(int i = 0; i < arrayLength; i++){
		printf("%d, ", array[i]);
	}
	printf("\n");

	//Frees the	memory	allocated
	free(array);

}