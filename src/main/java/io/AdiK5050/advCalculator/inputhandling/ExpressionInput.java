package main.java.io.AdiK5050.advCalculator.inputhandling;

import java.util.*;
import main.java.io.AdiK5050.advCalculator.utilities.InvalidPatternException;
/**
 * This class takes Expression Inputs as Strings then parse them into Numbers, Operators and Braces.
 * It stores the parsed Strings into Arraylist of type-String
 */
public class ExpressionInput {

    Scanner sc;
    protected final ArrayList<String> finalTokens = new ArrayList<>();
    public ExpressionInput(Scanner sc){
        this.sc = sc;
    }

    /**
     * This method takes Expression Input and stores then in the arraylist finalTokens
     *
     * @throws InvalidPatternException user-defined exception.
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
