package io.AdiK5050.advCalculator.operators;

import io.AdiK5050.advCalculator.utilities.DivisionByZeroException;
/**
 * This class contains a method "div()" which returns the division of elements of the array passed as argument.
 */
public class Division
{
    /**
     * The division occurs with the logic that smaller element always divides bigger one so the final answer will always be greater than 1
     * For detailed information consider the following example:-
     * Let's say the array elements are 10, 50, 20 and 90; variable div initaialised with zero... 
     * Every iteration will compare the element with value of div at that instant.
     * For example for the first iteration div = 1 and arr[i] = 10; 1 < 10 is true,
     * => div = 10 / 1 (if-block executed)
     * => div = 10
     * Similarly, second iteration executes as such:-
     * div = 10, arr[i] = 50; 10 < 50 is true,
     * => div = 50 / 10 (if-block executed)
     * => div = 5
     * Similarly, third iteration executes as such:-
     * div = 5, arr[i] = 20; 5 < 20 is true, 
     * => div = 20 / 5 (if-block executed)
     * => div = 4 and so on... 
     * For loop helps to subtract and store every element of the array passed as an argument.
     * @param arr This takes a an array of double type and returns the division.
     * @throws "DivisionByZeroException" exception predefined in it's class.
     */
    public double div(double... arr) throws DivisionByZeroException
    {
        int i; 
        double div = 1;
        for(i = 0; i < arr.length; i++)
        {
            if(arr[i] <= 0)
                throw new DivisionByZeroException();

            else 
                if(div < arr[i])
                    div = arr[i] / div;
                else
                    div = div / arr[i];
        }
            return div;
    }
}