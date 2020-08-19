package com.Scaler.ExpressionEvaluator;
import com.Scaler.Operator.*;
import java.util.*;

abstract public class ExpressionEvaluator {
    abstract public boolean Evaluate(String conditionalExpression, Map<String, Object> user);

    protected ArrayList<String> ReplaceAttributesWithValues(String conditionalExpression, Map<String, Object> user)
    {
        ArrayList<String> tokens = new ArrayList<String>();
        Set<String> operatorsList = OperatorInfo.GetOperatorsList();
        System.out.println("Number of operators available = " + operatorsList.size());
        String[] orig_tokens = conditionalExpression.toLowerCase().split(" ");
        Stack<String> ops;
        for(String token: orig_tokens)
        {
            if(operatorsList.contains(token))
            {
                tokens.add(token);
                //System.out.println(token);
                Operator operator = OperatorFactory.GetOperator(token);
                //System.out.println("Precedence of operator =" + operator.GetPrecedence());
            }
            else
            {
                Object value = user.get(token);
                if(value != null)
                {
                    tokens.add(String.valueOf(value));
                    //System.out.println("Operand value for token " + token + " is " + value);
                }
                else
                    tokens.add(token);
            }
        }
        return tokens;
    }
}
