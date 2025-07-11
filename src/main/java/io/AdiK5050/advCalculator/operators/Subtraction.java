package main.java.io.AdiK5050.advCalculator.operators;

import main.java.io.AdiK5050.advCalculator.utilities.ApplicationException;
import main.java.io.AdiK5050.advCalculator.utilities.MaximumInputReachedException;

/**
 * This class contains a method "sub()" which returns the difference of elements of the array passed as argument.
 */
public class Subtraction implements Expression {
    /**
     * Returns the final result of subtraction
     * The Subtraction occurs with the logic that smaller element always gets subtracted from bigger one so the final answer will always be positive
     * For detailed information consider the following example:-
     * Let's say the array elements are <code>1, 5, 2 and 9;</code> variable diff initialised with zero...
     * Every iteration will compare the element with value of diff at that instant.
     * For example for the first iteration <code>diff = 0 and arr[i] = 1; 0 &lt; 1 </code>is true,
     * <code>=> diff = 1 - 0 </code>(if-block executed)
     * <code>=> diff = 1</code>
     * Similarly, second iteration executes as such:-
     * <code>diff = 1, arr[i] = 5; 1 	&lt; 5</code> is true,
     * <code>=> diff = 5 - 1</code> (if-block executed)
     * <code>=> diff = 4</code>
     * Similarly, third iteration executes as such:-
     *<code> diff = 4, arr[i] = 2; 4 	&lt; 2</code> is false,
     * <code>=> diff = 4 - 2</code> (else-block executed)
     * <code>=> diff = 2</code> and so on...
     * For loop helps to subtract and store every element of the array passed as an argument.
     *
     * @param arr This takes an array of double type and returns the difference.
     * @throws MaximumInputReachedException user-defined exception.
     * @return double
     */
    @Override
    public double preform(double... arr) throws ApplicationException {
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