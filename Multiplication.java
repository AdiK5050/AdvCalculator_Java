package AdvCalculator.out.oprFiles;

import AdvCalculator.out.utilityFiles.MaxMultiplierExp;

/**
 * This class contains a method "mul()" to returns the product of elements of the array passed as argument
 */
public class Multiplication
{
    /**
     * The Multiplication occurs simple and straight. Each elements is multiplied with the variable "mul" and "mul" stores the result.
     * This method throws "MaxMultiplierExp" exception pre-difined in it's class.
     * For loop helps to multiply and store every element of the array passed as an argument.
     * @param arr This takes a an array of double type and returns the product.
     */
    public double mul(double... arr)
    {
        int i; 
        double mul = 1;

        for(i = 0; i < arr.length; i++)
            {
                try
                {
                    if(arr[i] > 7000)
                        throw new MaxMultiplierExp();
                    else 
                        mul *= arr[i];
                }
                catch(MaxMultiplierExp e)
                {
                    System.out.println(e.toString());
                    return -1;
                }
            }   
        return mul;
    }
}