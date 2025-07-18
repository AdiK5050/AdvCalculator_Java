package io.AdiK5050.advCalculator.inputhandling;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the code to take numbers user input and apply desired operation(add/subtract/multiply/divide).
 */
public class Input{
    public ArrayList<Double> arrDouble = new ArrayList<>();
    
    public double[] arr;
    public Scanner sc;

    /**
     * @param sc this takes scanner object as argument to enable number input for the user.
     */
    public Input(Scanner sc){
        this.sc = sc;
    }

    /**
     * This method parses the string input from the user to tokens of double type.
     */
    public void getToArr(){
        arr = arrDouble.stream().mapToDouble(Double :: doubleValue).toArray();
    }

    /**
     * Takes User Input.
     * This method takes user input in specified format such that number inputs are given then "stop" is passed as input to stop adding more inputs.
     * Formats acceptable:-
     * <p>
     * 1 5 2 9 'enter key pressed'
     * <p>
     * 'enter key pressed
     * <p>
     * output
     * <p>
     * OR,
     * <p>
     * 50
     * <p>
     * 20
     * <p>
     * 90'enter key pressed'
     * <p>
     * 'enter key pressed'
     * <p>
     * output
     */
    public void addElements(){
        boolean flag = true;
        int count = 0;
        System.out.println("Enter the numbers then press 'enter key' twice:- \nFor info in result evaluation refer to documentation");
        
        while(flag && count < 3){
            String input = sc.nextLine();
            String[] tokens = input.trim().split("\\s+");
            for(String token : tokens){
                try{
                    if(token.trim().isEmpty()){
                            flag = false;
                    } 
                    else{
                        try{
                            double num = Double.parseDouble(token);
                            arrDouble.add(num);
                        }catch(Exception e){
                            System.out.println("Invalid Input!! Enter only Numbers(whole or decimal)");
                            count++;
                            sc.nextLine();
                        }
                    }
                }catch(InputMismatchException e1){
                    System.out.println(e1);
                }
            }
        }
    }
}
