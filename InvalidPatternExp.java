package AdvCalculator.out.utilityFiles;
import java.lang.Exception;

/**
 * This class handles Exception where User input invalid pattern for Mixed-Calculation
 */
public class InvalidPatternExp extends Exception
{
    /**
     * Returns a String (Overridden from Exception class)
     */
    @Override 
    public String toString()
    {
        return "Invalid Patter!! Please specify symbols as directed";
    }
}
