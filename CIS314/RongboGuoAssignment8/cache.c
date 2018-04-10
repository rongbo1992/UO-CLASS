#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>


struct myCache{
    int valid;
    char *tag;
    char *block;
};



int main(int argc, char* argv[]){    
    FILE *tracefile;
    if (argc != 7)
    {
        if (strcmp(argv[0], "-h"))
        {
            printf("./sim2 <cache size> <associativity> <block size> <replace alg> <write policy> <trace file>\n");
            return 0;
        }
        else
        {
            fprintf(stderr, "Error: wrong number of parameters.\n");
            return -1;
        }
    }

    tracefile = fopen(argv[6], "r");

    if(tracefile == NULL)
    {
        fprintf(stderr, "Error: File is NULL.\n");
        return -1;
    }

    //Determining size of sbits, bbits, and tag
    int cachesize = atoi(argv[1]);
    int blocksize = atoi(argv[3]);
    int setnumber = (cachesize/blocksize);
    printf("setnumber: %d\n", setnumber);
    int setbits = (round((log(setnumber))/(log(2))));
    printf("sbits: %d\n", setbits);
    int blockbits = log(blocksize)/log(2);
    printf("bbits: %d\n", blockbits);
    int tagsize = 32 - (blockbits + setbits);
    printf("t: %d\n", tagsize);

    struct myCache newCache[setnumber];

    //Allocating Space for Tag Bits, initiating tag and valid to 0s
    for(i=0;i<setnumber;i++)
    {
        newCache[i].tag = (char *)malloc(sizeof(char)*(tagsize+1));
        for(j=0;j<tagsize;j++)
        {
            newCache[i].tag[j] = '0';
        }
        newCache[i].valid = 0;
    }

    printf("Enter 'r' for read, 'w' for write, 'p' to print, 'q' to quit: ");

    while(fgetc(tracefile)!='#')
    {    
        int setadd = 0;
        int totalset = 0;
  
        fseek(tracefile,-1,SEEK_CUR);
        fscanf(tracefile, "%x: %c %s\n", &trash, &readwrite, origtag);


        int size = strlen(origtag);
        int extra = (10 - size);
        for(i=0; i<extra; i++)
            input[i] = '0';

        for(i=extra, j=0; i<(size-(2-extra)); j++, i++)
            input[i]=origtag[j+2];

        input[8] = '\0';

        // Convert Hex to Binary
        hex2bin(input, output);

        //Resolving the Address into tbits, sbits, bbits
        for (xindex=0, jindex=(32-blockbits); jindex<32; jindex++, xindex++){
            bbits[xindex] = output[jindex];
            }
    bbits[xindex]='\0';

    for (xindex=0, kindex=(32-(blockbits+setbits)); kindex<32-(blockbits); kindex++, xindex++){
        sbits[xindex] = output[kindex];
    }
    sbits[xindex]='\0';

    for (xindex=0, lindex=0; lindex<(32-(blockbits+setbits)); lindex++, xindex++){
        tbits[xindex] = output[lindex];
    }
    tbits[xindex]='\0';

    for(xindex = 0, kindex = (setbits -1); xindex < setbits; xindex ++, kindex--){
            if (sbits[xindex] == '1')
                setadd = 1;
            if (sbits[xindex] == '0')
                setadd = 0;
            setadd = setadd * pow(2, kindex);
            totalset += setadd;
        }

        
        if (newCache[totalset].valid == 0){
            newCache[totalset].valid = 1;
            strcpy(newCache[totalset].tag, tbits);
        }

        else if (newCache[totalset].valid == 1){
            if(strcmp(newCache[totalset].tag, tbits) == 0){
                if (readwrite == 'W'){
                    scanf(“Enter 32-bit unsigned hex address: %x”， location);
                    scanf(“Enter 32-bit unsigned hex value: %x”， Key);

                }
                if (readwrite == 'R')
                printf("wrote set: %x, - tag: %x -valid: %x -value  %x", set, tag, valid, key<<4);    
            }
            else
            {
                if (readwrite == 'R')
                {
                    printf("wrote set: %x, - tag: %x -valid: %x -value  %x", set, tag, valid, key<<4);  
                }
                if (readwrite == 'W')
                {
                    scanf(“Enter 32-bit unsigned hex address: %x”， location);
                    scanf(“Enter 32-bit unsigned hex value: %x”， Key);
                }
                strcpy(newCache[totalset].tag, tbits);
            }
        }        
    }
}