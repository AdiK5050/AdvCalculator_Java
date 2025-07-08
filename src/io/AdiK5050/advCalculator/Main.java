package io.AdiK5050.advCalculator;

import java.util.Scanner;
import java.util.InputMismatchException;
import io.AdiK5050.advCalculator.inputhandling.*;
import io.AdiK5050.advCalculator.operators.*;

/**
 * This class contains the <code>main</code> method for user's choice.
 * <code>main</code> method deals with the user's choice utility to help interact with the calculator with ease.
 * @author Aditya Gupta
 * @version 1.0
 * @since 2025
 *
 *
 */
public class Main{
    /**
     * Users are supposed to input as directed. Integers from 0 to 5 to select calculation method or exit the program.
     *
     * @param args not supported
     * @throws InputMismatchException exception.
     */
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){
            Input objIn = new Input(sc);
            int choice = 0;

            do{
                System.out.println("\nPress 1 to Add multiple numbers\nPress 2 to Subtract multiple numbers\nPress 3 to Divide multiple numbers\nPress 4 to Multiply multiple numbers\nPress 5 to solve an expression \nPress 0 to exit");
                try{
                    choice = sc.nextInt();
                    if(choice < 0 || choice > 5)
                        throw new InputMismatchException();
                    sc.nextLine();
                }
                catch(InputMismatchException e){
                    System.out.println("Invalid Input!! Enter a valid Integer From 0 to 5...");
                    sc.nextLine();
                }

                try{
                    switch(choice){
                        case 1: 
                        objIn.addElements();
                        objIn.getToArr();
                        Addition objAdd = new Addition();
                        System.out.println(objAdd.add(objIn.arr));
                        break;

                        case 2:
                        objIn.addElements();
                        objIn.getToArr();
                        Subtraction objSub = new Subtraction();
                        System.out.println(objSub.sub(objIn.arr));
                        break;

                        case 3:
                        objIn.addElements();
                        objIn.getToArr();
                        Division objDiv = new Division();
                        System.out.println(objDiv.div(objIn.arr));
                        break;

                        case 4:
                        objIn.addElements();
                        objIn.getToArr();
                        Multiplication objMul = new Multiplication();
                        System.out.println(objMul.mul(objIn.arr));
                        break;

                        case 5:
                        ExpressionEvaluation objPostfixEvaluation = new ExpressionEvaluation(sc);
                        objPostfixEvaluation.inputExpression();
                        objPostfixEvaluation.toPostfix();
                        System.out.println("\nResult: " + objPostfixEvaluation.evaluateExpression());
                        break;
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }while(choice != 0);
        }
    }
}