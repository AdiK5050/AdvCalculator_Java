package main.java.io.AdiK5050.advCalculator.inputhandling;

import main.java.io.AdiK5050.advCalculator.inputhandling.interfaces.ExpressionHandler;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the code to take numbers user input and apply desired operation(add/subtract/multiply/divide).
 */
public class ExpressionHandlerFromScanner implements ExpressionHandler {
    private ArrayList<Double> arrDouble = new ArrayList<>();
    
    private double[] arr;
    private final Scanner sc;

    /**
     * @param sc this takes scanner object as argument to enable number input for the user.
     */
    public ExpressionHandlerFromScanner(Scanner sc){
        this.sc = sc;
    }

    /**
     * This method parses the string input from the user to tokens of double type.
     */
    @Override
    public void getToArr(){
        arr = arrDouble.stream().mapToDouble(Double :: doubleValue).toArray();
    }

    /**
     * Takes User Input.
     * This method takes user input in specified format such that number inputs are given then "stop" is passed as input to stop adding more inputs.
     */
    @Override
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

    @Override
    public double[] getArr() {
        return arr;
    }
}
