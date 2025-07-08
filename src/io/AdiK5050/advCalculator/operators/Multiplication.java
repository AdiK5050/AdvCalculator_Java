package io.AdiK5050.advCalculator.operators;

import io.AdiK5050.advCalculator.utilities.MaximumMultiplierReachedException;

/**
 * This class contains a method "mul()" to returns the product of elements of the array passed as argument.
 */
public class Multiplication
{
    /**
     * Returns the final result of multiplication
     * The Multiplication occurs simple and straight. Each element is multiplied with the variable "mul" and "mul" stores the result.
     * For loop helps to multiply and store every element of the array passed as an argument.
     *
     * @param arr This takes an array of double type and returns the product.
     * @throws MaximumMultiplierReachedException user-defined exception.
     * @return double
     */
    public double mul(double... arr) throws MaximumMultiplierReachedException
    {
        int i;
        double mul = 1;

        for(i = 0; i < arr.length; i++)
        {
            if(arr[i] > 7000)
                    throw new MaximumMultiplierReachedException();
            else 
                mul *= arr[i];
        }   
        return mul;
    }
}