package main.java.io.AdiK5050.advCalculator.operators;

import main.java.io.AdiK5050.advCalculator.utilities.ApplicationException;
import main.java.io.AdiK5050.advCalculator.utilities.DivisionByZeroException;
/**
 * This class contains a method "div()" which returns the division of elements of the array passed as argument.
 */
public class Division implements Expression {
    /**
     * Returns the final result of division
     * The division occurs with the logic that smaller element always divides bigger one so the final answer will always be greater than 1
     * For detailed information consider the following example:-
     * @param arr This takes an array of double type and returns the division.
     * @throws DivisionByZeroException user-defined exception.
     * @return double.
     */

    @Override
    public double preform(double... arr) throws ApplicationException {
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