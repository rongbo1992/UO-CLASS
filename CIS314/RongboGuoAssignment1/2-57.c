#include <stdio.h>
 
typedef unsigned char *byte_pointer; 

void show_bytes(byte_pointer start, int len) {
int i;
for (i = 0; i < len; i++)
printf(" %.2x", start[i]);
printf("\n");
}

void show_int(int x) {
show_bytes((byte_pointer) &x, sizeof(int));
}

void show_long(long x) {
show_bytes((byte_pointer) &x, sizeof(long));
}

void show_double(double x) {
show_bytes((byte_pointer) &x, sizeof(double));
}

int main(void){
	double c = 6.333; 
	show_int(66);
	show_long(1234567890);
	show_double(c);
}