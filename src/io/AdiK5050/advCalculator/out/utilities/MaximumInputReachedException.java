package io.AdiK5050.advCalculator.out.utilities;
import java.lang.Exception;

/**
 * This class handles Exceptions where User inputs a very big value
 */
public class MaximumInputReachedException extends Exception
{
    /**
     * Returns a String (Overridden from Exception class)
     */
    @Override 
    public String toString()
    {
        return "For Addition, Subtraction and Division the Maximum Input acceptable is 100000.0";
    }
}