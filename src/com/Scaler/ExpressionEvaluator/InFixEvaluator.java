package com.Scaler.ExpressionEvaluator;
import com.Scaler.Operator.*;
import java.util.*;

public class InFixEvaluator extends ExpressionEvaluator {
    public boolean Evaluate(String conditionalExpression, Map<String, Object> user){
        Set<String> operatorsList = OperatorInfo.GetOperatorsList();
        ArrayList<String> tokens = ReplaceAttributesWithValues(conditionalExpression, user);
        Stack<String> operand = new Stack<String>();
        Stack<String> operator = new Stack<String>();
        for(String token: tokens)
        {
            //System.out.println("Final token " + token);
            if(token.equals("(") )
                operator.push(token);
            else if (token.equals(")"))
            {
                while (!operator.peek().equals("("))
                    operand.push(String.valueOf(ApplyBinaryOperator(operator.pop(), operand.pop(), operand.pop())));
                operator.pop();
            }
            else if(operatorsList.contains(token))
            {
                while (!operator.empty() && !operator.peek().equals("(") && HasPrecedence(token, operator.peek()))
                    operand.push(String.valueOf(ApplyBinaryOperator(operator.pop(), operand.pop(), operand.pop())));

                // Push current token to operator.
                operator.push(token);
            }
            else //this is an operand
                operand.push(token);
        }
        // Entire expression has been parsed at this point, apply remaining operators to remaining values
        while (!operator.empty())
            operand.push(String.valueOf(ApplyBinaryOperator(operator.pop(), operand.pop(), operand.pop())));

        // Top of operand contains result, return it
        return Boolean.parseBoolean(operand.pop());
    }
}
