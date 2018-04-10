/*
Part A. Explain why the conditional test in the code always succeeds.
The reason why the if statement will always succeeds is the value will 
always be consider as unsigned number, the situation that value are negative
was been ignore.

Part B. Show how you can rewrite the conditional test to make it work properly. 

code shows below
*/

#include <stdio.h>
#include <string.h>

int copy_int(int val, void *buf, int maxbytes) {
	if (maxbytes - ((int) sizeof(val)) >= 0){
		memcpy(buf, (void *) &val, sizeof(val));
		return 1;
	}
	return 0;
} 

int main(){

	char buf[100];
    printf("maxbytes is 1, shoule return 0: %d\n", copy_int(0xDEADBEEF, buf, 1));
    printf("maxbytes is 2, shoule return 0: %d\n", copy_int(0xDEADBEEF, buf, 2));
    printf("maxbytes is 9, shoule return 1: %d\n", copy_int(0xDEADBEEF, buf, 9));
    printf("maxbytes is 12, shoule return 1: %d\n", copy_int(0xDEADBEEF, buf,12));
    return 0;

}

