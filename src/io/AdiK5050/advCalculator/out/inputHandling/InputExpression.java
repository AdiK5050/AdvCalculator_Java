package io.AdiK5050.advCalculator.out.inputHandling;

import java.util.*;
import io.AdiK5050.advCalculator.out.utilities.InvalidPatternException;

public class InputExpression {

    Scanner sc;
    protected final ArrayList<String> finalTokens = new ArrayList<>();
    public InputExpression(Scanner sc){
        this.sc = sc;
    }

    public void inputExpression() throws InvalidPatternException
    {
        System.out.println("Enter the expression:- (For example 1 + 2 (3 * 4)...)");
        String input = sc.nextLine();
        String[] tokens = input.trim().split("");
        StringBuilder number = new StringBuilder();
        int startBraceCount = 0;
        int endBraceCount = 0;
        
        for(String e: tokens)
            {
            
                if(Character.isDigit(e.charAt(0)) || e.charAt(0) == '.')
                {
                    number.append(e);
                }
                else if("+-/*()".indexOf(e.charAt(0)) != -1)
                {
                    if(number.length() > 0)
                    {
                        if(e.charAt(0) == '(')
                        {
                            finalTokens.add(number.toString());
                            number.setLength(0);
                            finalTokens.add("*");
                            finalTokens.add(e.toString());
                            startBraceCount++;
                            continue;
                        }
                        if(e.charAt(0) == ')')
                            endBraceCount++;
                        finalTokens.add(number.toString());
                        number.setLength(0);
                    }
                    
                    finalTokens.add(e.toString());
                }
                else if(e.charAt(0) == ' ')
                    continue;
                else 
                    throw new InvalidPatternException();
            }
        
        if(startBraceCount != endBraceCount)
            throw new InvalidPatternException();

        if(number.length() > 0)
        {
            finalTokens.add(number.toString());
            number.setLength(0);
        }
    }


}
