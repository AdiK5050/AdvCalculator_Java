package io.AdiK5050.advCalculator.out.utilities;
import java.lang.Exception;

/**
 * This class handles Exception where User input invalid pattern for Mixed-Calculation
 */
public class InvalidPatternException extends Exception
{
    /**
     * Returns a String (Overridden from Exception class)
     */
    @Override 
    public String toString()
    {
        return "Invalid Pattern!! Please specify symbols as directed";
    }
}
