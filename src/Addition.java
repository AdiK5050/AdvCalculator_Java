package AdvCalculator.out.oprFiles;

import AdvCalculator.out.utilityFiles.MaxInputExp;

/**
 * This class contains a method "add()" which returns the sum of elements of the array passed as argument.
 */
public class Addition 
{
    /**
     * The Addition occurs simple and straight. Each elements is added with the variable "sum" and "sum" stores the result.
     * This method throws "MaxInputExp" exception pre-difined in it's class.
     * For loop helps to add and store every element of the array passed as an argument.
     * @param arr This takes a an array of double type and returns the sum.
     */
    public double add(double... arr)
    {
        int i;
        double sum = 0;
        for(i = 0; i < arr.length; i++)
        {
            try
            {
                if(arr[i] > 100000.0)
                    throw new MaxInputExp();
                else
                    sum += arr[i];
            }
            catch(MaxInputExp e)
                {
                    System.out.println(e.toString());
                    return -1;
                }
        }
        return sum;
    }
}

