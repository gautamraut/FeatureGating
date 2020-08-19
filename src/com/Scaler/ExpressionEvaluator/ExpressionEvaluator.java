package com.Scaler.ExpressionEvaluator;
import com.Scaler.Operator.*;
import java.util.*;

abstract public class ExpressionEvaluator {
    abstract public boolean Evaluate(String conditionalExpression, Map<String, Object> user);

    protected boolean ApplyBinaryOperator(String operator, String operand1, String operand2)
    {
        Operator currOperatorObj = OperatorFactory.GetOperator(operator);
        return currOperatorObj.Operate(new String[]{operand2, operand1});
    }

    protected boolean HasPrecedence(String operator1, String operator2)
    {
        //System.out.println("Operator1: " + operator1 + " Operator2: " + operator2);
        Operator Operator1Obj = OperatorFactory.GetOperator(operator1);
        Operator Operator2Obj = OperatorFactory.GetOperator(operator2);
        if(Operator1Obj.GetPrecedence() > Operator2Obj.GetPrecedence())
            return true;
        else
            return false;
    }

    protected ArrayList<String> ReplaceAttributesWithValues(String conditionalExpression, Map<String, Object> user)
    {
        ArrayList<String> tokens = new ArrayList<String>();
        Set<String> operatorsList = OperatorInfo.GetOperatorsList();
        //System.out.println("Number of operators available = " + operatorsList.size());
        String[] orig_tokens = conditionalExpression.toLowerCase().split(" ");
        for(String token: orig_tokens)
        {
            if(operatorsList.contains(token))
                tokens.add(token);
            else
            {
                Object value = user.get(token);
                if(value != null)
                {
                    tokens.add(String.valueOf(value));
                    //System.out.println("Operand value for token " + token + " is " + value);
                }
                else // This is already an operand so add directly
                    tokens.add(token);
            }
        }
        return tokens;
    }
}
