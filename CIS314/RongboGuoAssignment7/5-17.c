/*
Rongbo Guo
CIS 314
Assignment 7
*/

#include <sys/time.h>
#include <stdlib.h>
#include <stdio.h>

#define VECTOR_SIZE 3 
typedef long long d; 
typedef d *vec_ptr;

d * get_vec_start(vec_ptr v) { 
	return v;
}

int vec_length(vec_ptr v) {
	return VECTOR_SIZE; 
}

void inner4(vec_ptr u, vec_ptr v, d *dest){
	
	long int i;
	int length = vec_length(u);
	d *udata = get_vec_start(u);
	d *vdata = get_vec_start(v);
	d sum = (d) 0;
	d sum2 = (d) 0;
	d sum3 = (d) 0;
	d sum4 = (d) 0;

	for (i=0; i < length; i+=4){
		sum += udata[i] * vdata[i];
		sum2 += udata[i+1] * vdata[i+2];
		sum3 += udata[i+2] * vdata[i+3];
		sum4 += udata[i+3] * vdata[i+4];
	}
	
	for (; i < length; i++){
		sum = sum + udata[i] * vdata[i];
	}

	*dest = sum + sum2 + sum3 +sum4;
}

int main(int argc, char const *argv[])
{
	int ms = 0;
	vec_ptr a= (vec_ptr) malloc(sizeof(d)*VECTOR_SIZE);
	// give (a) a value
	d ret=0;
	struct timeval start;
	gettimeofday(&start, NULL);
	inner4(a , a, &ret);
	struct timeval current;
	gettimeofday(&current, NULL);

	long long elapsed = (current.tv_sec - start.tv_sec)*1000000LL + (current.tv_usec - start.tv_usec);
	printf("%f Seconds\n", elapsed/1000000.0);

	return 0;
}