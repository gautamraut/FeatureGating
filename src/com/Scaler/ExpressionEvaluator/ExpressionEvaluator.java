package com.Scaler.ExpressionEvaluator;
import java.util.Map;

public interface ExpressionEvaluator {
    public boolean Evaluate(String conditionalExpression, Map<String, Object> user);
}
