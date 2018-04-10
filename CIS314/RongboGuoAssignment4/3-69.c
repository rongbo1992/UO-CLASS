/*
Rongbo Guo
CIS 314
Assignment 4

A.Generate a C version of the function, using a while loop. 
answer: the c code shows below.

B. Explain in English what this function computes. 
answer: The function shows below is through a tree struct and keep going down to the 
right branch until it going through all nodes. Finally return the value.


*/

#include <stdio.h>

typedef struct ELE *tree_ptr;

struct ELE{
  long val;
  tree_ptr left;
  tree_ptr right;
};

long trace(tree_ptr tp){
	struct ELE* n = tp;
	if(!n) {
		return 0;
	}
	else{
    	while(n->val) {       		
      		n = n->right;
    	}
    return n->val;
  	}
}


int main(){
	return 0;
}