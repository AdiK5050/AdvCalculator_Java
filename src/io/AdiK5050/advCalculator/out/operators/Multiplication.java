package io.AdiK5050.advCalculator.out.operators;

import io.AdiK5050.advCalculator.out.utilities.MaximumMultiplierReachedException;

/**
 * This class contains a method "mul()" to returns the product of elements of the array passed as argument
 */
public class Multiplication
{
    /**
     * The Multiplication occurs simple and straight. Each elements is multiplied with the variable "mul" and "mul" stores the result.
     * @throws MaximumMultiplierReachedException
     * For loop helps to multiply and store every element of the array passed as an argument.
     * @param arr This takes a an array of double type and returns the product.
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