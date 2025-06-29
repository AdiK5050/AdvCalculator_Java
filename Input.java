package AdvCalculator.out.InputHandling;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class contains the code to take numbers user input and apply desired operation(add/subtract/multiply/divide).
 */
public class Input
{
    public ArrayList<Double> arrDouble = new ArrayList<>();
    public double[] arr;
    public Scanner sc;

    /**
     * @param sc this takes scanner object as argument to enable number input for the user
     */
    public Input(Scanner sc)
    {
        this.sc = sc;
    }

    /**
     * This method parses the string input from the user to tokens of double type
     */
    public void getToArr()
    {
        arr = arrDouble.stream().mapToDouble(Double :: doubleValue).toArray();
    }

    /**
     * This method takes user input in specified format such that number inputs are given then "stop" is passed as input to stop adding more number inputs.
     * Formats acceptable:- 
     * 1 5 2 9 'enter key pressed'
     * 'enter key pressed'
     * output
     * 
     * OR,
     * 10
     * 50
     * 20
     * 90'enter key pressed'
     * 'enter key pressed'
     * output
     */
    public void addElements()
    {
        boolean flag = true;
        int count = 0;
        System.out.println("Enter the numbers then press 'enter key' twice:- \nFor info in result evaluation refer to documentation");
        
        while(flag && count < 3)
        {
            String in = sc.nextLine();
            String[] tokens = in.trim().split("\\s+");
            for(String token : tokens)
            {
                try
                {
                    if(token.trim().isEmpty())
                    {
                            flag = false;
                    } 
                    else
                    {
                        {
                            try
                            {
                                double num = Double.parseDouble(token);
                                arrDouble.add(num);
                            }
                            catch(Exception e)
                            {
                                System.out.println("Invalid Input!! Enter only Numbers(whole or decimal) Or 'stop' to get result");
                                count++;
                                sc.nextLine();
                            }
                        }
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            }
        }
    }
}
