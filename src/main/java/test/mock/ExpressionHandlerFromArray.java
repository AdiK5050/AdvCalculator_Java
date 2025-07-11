package main.java.test.mock;

import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionHandler;

public class ExpressionHandlerFromArray implements ExpressionHandler {
    private final double[] arr;

    public ExpressionHandlerFromArray(double[] arr) {
        this.arr = arr;
    }

    @Override
    public void getToArr() {

    }

    @Override
    public void addElements() {
    }

    @Override
    public double[] getArr() {
        return arr;
    }
}
