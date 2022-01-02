#include <iostream>
#include <stdio.h>     
#include <stdlib.h>  
#include <limits.h>

int main()
{
	long large_units;
	long med_units;
	long small_units;
	
	// scan user input as a long data type
    printf ("Enter number of large units:");
    scanf ("%li", &large_units); 
    
	printf ("Enter number of medium units:");
    scanf ("%li", &med_units); 
    
    printf ("Enter number of small units:");
    scanf ("%li", &small_units); 
    
    // add values together
    long total_units = large_units + med_units + small_units;
    
    // conditional statement to check for upper and lower bounds of long data type
    if(total_units < LONG_MIN || total_units > LONG_MAX)
    printf("Int Overflow!");
    
    else printf("Total units: %li", total_units);
    
}