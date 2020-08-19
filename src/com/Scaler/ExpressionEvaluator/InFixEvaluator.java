package com.Scaler.ExpressionEvaluator;
import com.Scaler.Operator.*;
import java.util.*;

public class InFixEvaluator implements ExpressionEvaluator {
    public boolean Evaluate(String conditionalExpression, Map<String, Object> user){
        Set<String> operatorsList = OperatorInfo.GetOperatorsList();
        System.out.println("Number of operators available = " + operatorsList.size());
        String[] tokens = conditionalExpression.toLowerCase().split(" ");
        Stack<String> ops;
        for(String token: tokens)
        {
            if(operatorsList.contains(token))
            {
                System.out.println(token);
                Operator operator = OperatorFactory.GetOperator(token);
                System.out.println("Precedence of operator =" + operator.GetPrecedence());
            }
            else
            {
                Object value = user.get(token);
                if(value != null)
                    System.out.println("Operand value for token " + token + " is " + value);
            }
        }

        return true;
    }
}
