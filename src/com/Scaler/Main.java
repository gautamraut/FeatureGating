package com.Scaler;
import com.Scaler.ExpressionEvaluator.ExpressionEvaluator;
import com.Scaler.ExpressionEvaluator.InFixEvaluator;

import java.util.*;

public class Main {

    static boolean isAllowed(String conditionalExpression, String featureName, Map<String, Object> user)
    {
        ExpressionEvaluator evaluator = new InFixEvaluator();
        if(evaluator.Evaluate(conditionalExpression, user))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("age", 28);
        user.put("gender", "Female");
        user.put("past_order_amount", "5000");

        System.out.println(isAllowed("( age > 25 AND gender == \"Male\" ) OR ( past_order_amount > 10000 )", "Feature1", user));
    }
}
