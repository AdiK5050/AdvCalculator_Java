package AdvCalculator.out.oprFiles;

import AdvCalculator.out.utilityFiles.MaxInputExp;

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
     * This method throws "MaxInputExp" exception predefined in it's class.
     * @param arr This takes a an array of double type and returns the difference.
     */
    public double sub(double... arr)
    {
        int i;
        double diff = 0;
        for(i = 0; i < arr.length; i++)
        {
            try
            {
                if(arr[i] > 100000.0)
                    throw new MaxInputExp();
                else 
                    if(diff < arr[i])
                        diff = arr[i] - diff;
                    else 
                        diff = diff - arr[i];
            }
            catch(MaxInputExp e)
            {
                System.out.println(e.toString());
                return -1;
            }
        }
        return diff;
    }
}