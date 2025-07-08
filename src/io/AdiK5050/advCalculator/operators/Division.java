package io.AdiK5050.advCalculator.operators;

import io.AdiK5050.advCalculator.utilities.DivisionByZeroException;
/**
 * This class contains a method "div()" which returns the division of elements of the array passed as argument.
 */
public class Division
{
    /**
     * Returns the final result of division
     * The division occurs with the logic that smaller element always divides bigger one so the final answer will always be greater than 1
     * For detailed information consider the following example:-
     * Let's say the array elements are <code>10, 50, 20 and 90;</code> variable div initialized with zero...
     * Every iteration will compare the element with value of div at that instant.
     * For example for the first iteration <code>div = 1</code> and <code>arr[i] = 10; 1 	&lt; 10</code> is true,
     * => <code>div = 10 / 1</code> (if-block executed)
     * => <code>div = 10</code>
     * Similarly, second iteration executes as such:-
     *<code> div = 10, arr[i] = 50; 10 &lt;</code> 50 is true,
     * <code>=> div = 50 / 10</code> (if-block executed)
     * <code>=> div = 5</code>
     * Similarly, third iteration executes as such:-
     * <code>div = 5, arr[i] = 20; 5 	&lt; 20</code> is true,
     * <code>=> div = 20 / 5 </code>(if-block executed)
     * <code>=> div = 4</code> and so on...
     * For loop helps to subtract and store every element of the array passed as an argument.
     *
     * @param arr This takes an array of double type and returns the division.
     * @throws DivisionByZeroException user-defined exception.
     * @return double.
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