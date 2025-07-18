package io.AdiK5050.advCalculator.utilities;
import java.lang.Exception;

/**
 * This class handles Exception where User input invalid pattern for Mixed-Calculation.
 */
public class InvalidPatternException extends Exception
{
    /**
     * Returns a String (Overridden from Exception class).
     */
    @Override 
    public String toString()
    {
        return "\nInvalid Pattern!! Please make sure you input numbers, operators and braces properly\n(For example 1 + 2 (3 * 4)...) ";
    }
}
