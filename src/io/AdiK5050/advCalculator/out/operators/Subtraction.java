package io.AdiK5050.advCalculator.out.operators;

import io.AdiK5050.advCalculator.out.utilities.MaximumInputReachedException;

/**
 * This class contains a method "sub()" which returns the difference of elements of the array passed as argument.
 */
public class Subtraction
{
    /**
     * The Subtraction occurs with the logic that smaller element always gets subtracted from bigger one so the final answer will always be positive
     * For detailed information consider the following example:-
     * Let's say the array elements are 1, 5, 2 and 9; variable diff initaialised with zero... 
     * Every iteration will compare the element with value of diff at that instant.
     * For example for the first iteration diff = 0 and arr[i] = 1; 0 < 1 is true,
     * => diff = 1 - 0 (if-block executed)
     * => diff = 1
     * Similarly, second iteration executes as such:-
     * diff = 1, arr[i] = 5; 1 < 5 is true,
     * => diff = 5 - 1 (if-block executed)
     * => diff = 4
     * Similarly, third iteration executes as such:-
     * diff = 4, arr[i] = 2; 4 < 2 is false, 
     * => diff = 4 - 2 (else-block executed)
     * => diff = 2 and so on... 
     * For loop helps to subtract and store every element of the array passed as an argument.
     * @throws MaximumInputReachedException
     * @param arr This takes a an array of double type and returns the difference.
     */
    public double sub(double... arr) throws MaximumInputReachedException
    {
        int i;
        double diff = 0;
        for(i = 0; i < arr.length; i++)
        {
            if(arr[i] > 100000.0)
                    throw new MaximumInputReachedException();
            else 
                if(diff < arr[i])
                    diff = arr[i] - diff;
                else 
                    diff = diff - arr[i];
        }
        return diff;
    }
}