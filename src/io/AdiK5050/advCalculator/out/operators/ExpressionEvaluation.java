package io.AdiK5050.advCalculator.out.operators;

import java.util.*;
import io.AdiK5050.advCalculator.out.inputHandling.InputExpression;
import io.AdiK5050.advCalculator.out.utilities.InvalidPatternException;

public class ExpressionEvaluation extends InputExpression
{
    
    public static final Map<String, Integer> precedence = new HashMap<>();
    public String postfixOutput = new String();

    static
    {
    precedence.put("+" , 1);
    precedence.put("-" , 1);
    precedence.put("*" , 2);
    precedence.put("/" , 2);
    }
    public ExpressionEvaluation(Scanner sc)
    {
        super(sc);
    }

    boolean isNumber(String token)
    {
        try
        {
            Double.parseDouble(token);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }

    boolean isOperator(String token)
    {
        return precedence.containsKey(token);
    }
    public void toPostfix() throws InvalidPatternException
    {
        Stack<String> stack = new Stack<>();
        StringBuilder postfixOutput = new StringBuilder();

        for(String token : finalTokens)
        {
            if(isNumber(token))
                postfixOutput.append(token).append(" ");

            else if(isOperator(token))
            {
                while(!stack.empty() && isOperator(stack.peek()) && precedence.get(stack.peek()) >= precedence.get(token))
                    postfixOutput.append(stack.pop()).append(" ");
                stack.push(token);
            }
            else if(token.equals("("))
            {
                stack.push(token);
            }
            else if(token.equals(")"))
            {
                while(!stack.isEmpty() && !stack.peek().equals("(")) 
                {
                    postfixOutput.append(stack.pop()).append(" ");
                }
                if(!stack.isEmpty() && stack.peek().equals("("))
                {
                    stack.pop();
                }
                else
                    throw new InvalidPatternException();
            }
        }
        while(!stack.isEmpty())
        {
            postfixOutput.append(stack.pop()).append(" ");
        }
    }

    public double evaluateExpression() throws IllegalArgumentException
    {
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfixOutput.toString().split(" ");

        for(String token : tokens)
        {
            if(isNumber(token))
                stack.push(Double.parseDouble(token));
            
            else if(isOperator(token))
            {
                if(stack.size() < 2 || stack.size() <= 0)
                    throw new IllegalArgumentException("Not Enough operands for the operator: " + token);

                double b = stack.pop();
                double a = stack.pop();
                
                switch(token)
                {
                case "+"-> stack.push(a + b);
                case "-"-> stack.push(a - b);
                case "*"-> stack.push(a * b);
                case "/"-> stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }
}