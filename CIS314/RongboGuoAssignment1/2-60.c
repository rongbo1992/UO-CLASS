# include <stdio.h>

unsigned replace_byte(unsigned x, int i, unsigned char b){
	unsigned char  *a = (unsigned char*)&x;
		a[i] = b;
	return x;
}

int main(){
	printf("0x%x\n", replace_byte(0x12345678, 0, 0xAB));
	printf("0x%x\n", replace_byte(0x12345678, 1, 0xAB));
	printf("0x%x\n", replace_byte(0x12345678, 2, 0xAB));
	printf("0x%x\n", replace_byte(0x12345678, 3, 0xAB));
	return 0;
}