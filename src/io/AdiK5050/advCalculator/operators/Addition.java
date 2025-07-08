package io.AdiK5050.advCalculator.operators;

import io.AdiK5050.advCalculator.utilities.MaximumInputReachedException;
/**
 * This class contains a method "add()" which returns the sum of elements of the array passed as argument.
 */
public class Addition 
{
    /**
     * Returns the final result of addition
     * The Addition occurs simple and straight. Each element is added with the variable "sum" and "sum" stores the result.
     * For loop helps to add and store every element of the array passed as an argument.
     *
     * @param arr This takes an array of double type and returns the sum.
     * @throws MaximumInputReachedException user-defined exception.
     * @return double
     */
    public double add(double... arr) throws MaximumInputReachedException
    {
        int i;
        double sum = 0;
        for(i = 0; i < arr.length; i++)
        {
            if(arr[i] > 100000.0)
                throw new MaximumInputReachedException();
            else
                sum += arr[i];
        }
        return sum;
    }
}

