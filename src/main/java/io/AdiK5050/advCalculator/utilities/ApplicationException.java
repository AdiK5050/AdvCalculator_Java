package main.java.io.AdiK5050.advCalculator.utilities;

public class ApplicationException extends Exception {
    public ApplicationException() {
    }

    public ApplicationException(String message) {
        super(message);
    }

    public ApplicationException(String message, Throwable cause) {
        super(message, cause);
    }
}
