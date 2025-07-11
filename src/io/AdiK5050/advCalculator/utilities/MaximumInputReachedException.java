package io.AdiK5050.advCalculator.utilities;
import java.lang.Exception;

/**
 * This class handles Exceptions where User inputs a very big value.
 */
public class MaximumInputReachedException extends ApplicationException {
    /**
     * Returns a String (Overridden from Exception class).
     */
    @Override 
    public String toString()
    {
        return "\nFor Addition, Subtraction and Division the Maximum Input acceptable is 100000.0";
    }
}