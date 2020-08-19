package com.Scaler;
import com.Scaler.ExpressionEvaluator.*;
import java.util.*;

public class Main {

    static boolean isAllowed(String conditionalExpression, String featureName, Map<String, Object> user)
    {
        ExpressionEvaluator evaluator = new InFixEvaluator(); //Here we can change any new evaluator like postfix/prefix
        if(evaluator.Evaluate(conditionalExpression, user))
            return true;
        return false;
    }

    public static void main(String[] args) {
        Map<String, Object> user = new HashMap<String, Object>();
        user.put("age", 28);
        user.put("gender", "Female");
        user.put("past_order_amount", "5000");

        String expression = "( age > 25 AND gender == Male ) OR ( past_order_amount > 10000 )"; //Assumption is tokens will be space separated
        String featureName = "Same Day delivery";

        if(isAllowed(expression, featureName, user))
            System.out.println("The feature " + featureName + " is available for this user");
        else
            System.out.println("The feature " + featureName + " is not available for this user");
    }
}
