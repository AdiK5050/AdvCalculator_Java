package io.AdiK5050.advCalculator.utilities;
import java.lang.Exception;

/**
 * This Class handles Exceptions where User inputs a very big value for Multiplication.
 */
public class MaximumMultiplierReachedException extends Exception
{
    /**
     * Returns a String (Overridden from Exception class).
     */
    @Override
    public String toString()
    {
        return "\nFor Multiplication the Maximum Input acceptable is 7000.0";
    }
}