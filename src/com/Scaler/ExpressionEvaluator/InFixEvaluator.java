package com.Scaler.ExpressionEvaluator;
import com.Scaler.Operator.*;
import java.util.*;

public class InFixEvaluator extends ExpressionEvaluator {
    public boolean Evaluate(String conditionalExpression, Map<String, Object> user){
        Set<String> operatorsList = OperatorInfo.GetOperatorsList();
        ArrayList<String> tokens = ReplaceAttributesWithValues(conditionalExpression, user);
        for(String token: tokens)
        {
            System.out.println("Final token " + token);
        }

        return true;
    }
}
