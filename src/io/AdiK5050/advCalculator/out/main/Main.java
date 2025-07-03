package io.AdiK5050.advCalculator.out.main;

import java.util.Scanner;
import java.util.InputMismatchException;
import io.AdiK5050.advCalculator.out.utilities.*;
import io.AdiK5050.advCalculator.out.inputHandling.Input;
import io.AdiK5050.advCalculator.out.operators.*;

/**
 * This class contains the main method which deals with the user's choice utility to help interact with the calculator with ease.
 */
class Main
{
    /**
     * Users are supposed to input as directed. Integers from 0 to 5 to select calculation method or exit the program.
     * @param args this takes command-line arguements
     * This method throws "InputMismatchException" exception.
     */
    public static void main(String args[])
    {
        try(Scanner sc = new Scanner(System.in))
        {
            Input objIn = new Input(sc);
            int ch = 0;
            
            do
            {
                System.out.println("Press 1 to Add multiple numbers\nPress 2 to Subtract multiple numbers\nPress 3 to Divide multiple numbers\nPress 4 to Multiply multiple numbers\nPress 5 to solve an expression \nPress 0 to exit");
                try
                {
                    ch = sc.nextInt();
                    if(!(ch > 0 && ch <= 5))
                        throw new InputMismatchException();
                    sc.nextLine();
                }
                catch(InputMismatchException e)
                {
                    System.out.println("Invalid Input!! Enter a valid Integer From 0 to 5...");
                    sc.nextLine();
                }

                try{
                    switch(ch)
                    {
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
                        System.out.println("This feature not available. Coming soon...");
                        break;
                    }
                }catch(Exception e){
                    System.out.println(e.toString());
                }
                
            }while(ch != 0);
        }
    }
}