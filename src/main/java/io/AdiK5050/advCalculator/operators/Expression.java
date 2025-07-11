package main.java.io.AdiK5050.advCalculator.operators;

import main.java.io.AdiK5050.advCalculator.utilities.ApplicationException;

public interface Expression {
    double preform(double... arr) throws ApplicationException;
}
