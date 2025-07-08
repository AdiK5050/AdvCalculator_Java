package io.AdiK5050.advCalculator.inputHandling;

import java.util.*;
import io.AdiK5050.advCalculator.utilities.InvalidPatternException;
/**
 * This class takes Expression Inputs as String Input then parse them into Numbers(double), Operators and Braces.
 * It stores them into Arraylist of type-String
 */
public class InputExpression{

    Scanner sc;
    protected final ArrayList<String> finalTokens = new ArrayList<>();
    public InputExpression(Scanner sc){
        this.sc = sc;
    }

    /**
     * @param input it takes user input(an expression) as a String.
     * @param tokens it tokenise the expression into characters.
     * @param number it builds the number digit by digit and stores them until an operator is encountered.
     * @param startBraceCount it keeps count of number of opening braces to check validity of the expression
     * @param endBraceCount it keeps count of number of closing braces to check validity of the expression
     * @throws InvalidPatternException
     */
    public void inputExpression() throws InvalidPatternException
    {
        System.out.println("Enter the expression:- ");
        String input = sc.nextLine();
        String[] tokens = input.trim().split("");
        StringBuilder number = new StringBuilder();
        int startBraceCount = 0;
        int endBraceCount = 0;
        
        for(String e: tokens){
            if(Character.isDigit(e.charAt(0)) || e.charAt(0) == '.'){
                number.append(e);
            }
            else if("+-/*()".indexOf(e.charAt(0)) != -1){
                if(number.length() > 0){
                    if(e.charAt(0) == '('){
                        finalTokens.add(number.toString());
                        number.setLength(0);
                        finalTokens.add("*");
                        finalTokens.add(e.toString());
                        startBraceCount++;
                        continue;
                    }
                    else if(e.charAt(0) == ')'){
                        finalTokens.add(number.toString());
                        number.setLength(0);
                        finalTokens.add(e.toString());
                        endBraceCount++;
                        continue;
                    }
                    finalTokens.add(number.toString());
                    number.setLength(0);
                }
                else 
                    if(e.charAt(0) == '(')
                        startBraceCount++;
                    else if(e.charAt(0) == ')')
                        endBraceCount++;
                
                finalTokens.add(e.toString());
            }
            else if(e.charAt(0) == ' ')
                continue;
            else 
                throw new InvalidPatternException();
        }
        if(startBraceCount != endBraceCount)
            throw new InvalidPatternException();

        if(number.length() > 0){
            finalTokens.add(number.toString());
            number.setLength(0);
        }    
        System.out.println("Parsed Expression:- ");
        for(String s: finalTokens)
            System.out.print(s + ",");
        System.out.println();
    }
}
