package io.AdiK5050.advCalculator.utilities;
import java.lang.Exception;

/**
 * This class handles Exceptions where User tries to divide any number by Zero "0".
 */
public class DivisionByZeroException extends ApplicationException {
    /**
     * Returns a String (Overridden from Exception class).
     */
    @Override
    public String toString()
    {
        return "\nDivision By Zero is Invalid!! Proceed with a different value...";
    }
}