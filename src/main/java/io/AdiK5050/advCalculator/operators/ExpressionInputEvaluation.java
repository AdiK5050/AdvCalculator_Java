package main.java.io.AdiK5050.advCalculator.operators;

import java.util.*;
import main.java.io.AdiK5050.advCalculator.inputhandling.ExpressionInput;
import main.java.io.AdiK5050.advCalculator.utilities.InvalidPatternException;
/**
 * This class Processes expression from Infix to Postfix and evaluates the final result.
 */
public class ExpressionInputEvaluation extends ExpressionInput {
    
    public static final Map<String, Integer> precedence = new HashMap<>();
    public String postfixOutput = new String();

    static{
    precedence.put("+" , 1);
    precedence.put("-" , 1);
    precedence.put("*" , 2);
    precedence.put("/" , 2);
    }
    /**
     * This is the class constructor used to call the super-class constructor.
     *
     * @param sc takes scanner object.
     */
    public ExpressionInputEvaluation(Scanner sc){
        super(sc);
    }

    /**
     * This method parse argument into double returns true if the argument passed is a number or else returns false.
     *
     * @param token this takes String input.
     * @return boolean
     */
    boolean isNumber(String token){
        try{
            Double.parseDouble(token);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }
    /**
     * This class returns true if the argument passed is the key in the Map defined as class member.
     *
     * @param token this takes String input.
     * @return boolean
     */
    boolean isOperator(String token){
        return precedence.containsKey(token);
    }
    /**
     * This method converts the infix expression into postfix expression
     *
     * @throws InvalidPatternException user-defined exception.
     */
    public void toPostfix() throws InvalidPatternException{
        Stack<String> stack = new Stack<>();
        StringBuilder postFixing = new StringBuilder();

        for(String token : finalTokens){
            if(isNumber(token))
                postFixing.append(token).append(" ");

            else if(isOperator(token)){
                while(!stack.empty() && isOperator(stack.peek()) && precedence.get(stack.peek()) >= precedence.get(token))
                    postFixing.append(stack.pop()).append(" ");
                stack.push(token);
            }
            else if(token.equals("(")){
                stack.push(token);
            }
            else if(token.equals(")")){
                while(!stack.isEmpty() && !stack.peek().equals("(")){
                    postFixing.append(stack.pop()).append(" ");
                }
                if(!stack.isEmpty() && stack.peek().equals("(")){
                    stack.pop();
                }
                else
                    throw new InvalidPatternException();
            }
        }
        while(!stack.isEmpty()){
            postFixing.append(stack.pop()).append(" ");
        }
        postfixOutput = postFixing.toString();
    }

    /**
     * This method evaluates the postfix-ed expression and returns the final result.
     *
     * @return double.
     * @throws IllegalArgumentException exception.
     * @throws InvalidPatternException user-defined exception.
     */
    public double evaluateExpression() throws IllegalArgumentException, InvalidPatternException{
        Stack<Double> stack = new Stack<>();
        String[] tokens = postfixOutput.toString().split(" ");

        for(String token : tokens){
            System.out.print(token + ",");
            if(isNumber(token))
                stack.push(Double.parseDouble(token));
            
            else if(isOperator(token)){
                if(stack.size() < 2)
                    throw new IllegalArgumentException("Not Enough operands for the operator: " + token);
                double b = stack.pop();
                double a = stack.pop();
                
                switch(token){
                case "+" -> stack.push(a + b);
                case "-" -> stack.push(a - b);
                case "*" -> stack.push(a * b);
                case "/" -> stack.push(a / b);
                }
            }
            else
                throw new IllegalArgumentException("Invalid Token: "+ token);
        }
            
        if(stack.size() != 1)
                throw new InvalidPatternException();
        return stack.pop();
    }
}