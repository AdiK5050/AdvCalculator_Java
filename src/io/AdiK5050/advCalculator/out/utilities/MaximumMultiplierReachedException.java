package io.AdiK5050.advCalculator.out.utilities;
import java.lang.Exception;

/**
 * This Class handles Exceptions where User inputs a very big value for Multiplication
 */
public class MaximumMultiplierReachedException extends Exception
{
    /**
     * Returns a String (Overridden from Exception class)
     */
    @Override
    public String toString()
    {
        return "For Multiplication the Maximum Input acceptable is 7000.0";
    }
}