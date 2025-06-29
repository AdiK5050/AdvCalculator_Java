package AdvCalculator.out.utilityFiles;
import java.lang.Exception;

/**
 * This class handles Exceptions where User inputs a very big value
 */
public class MaxInputExp extends Exception
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