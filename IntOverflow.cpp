#include <iostream>
#include <stdio.h>     
#include <stdlib.h>  
#include <limits.h>

int main()
{
	short large_units;
	short med_units;
	short small_units;
	
	// scan user input as a short data type
    printf ("Enter number of large units:");
    scanf ("%hd", &large_units); 
    
	printf ("Enter number of medium units:");
    scanf ("%hd", &med_units); 
    
    printf ("Enter number of small units:");
    scanf ("%hd", &small_units); 
    
    // add values together
    int total_units = large_units + med_units + small_units;
    
    // conditional statement to check for upper and lower bounds of short data type
    if(total_units < SHRT_MIN || total_units > SHRT_MAX)
    printf("Int Overflow!");
    
    else printf("Total units: %hd", total_units);
    
}