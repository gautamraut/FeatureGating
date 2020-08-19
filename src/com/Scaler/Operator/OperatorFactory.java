package com.Scaler.Operator;

public class OperatorFactory {
    public static Operator GetOperator(String operator)
    {
        switch(operator) {
            case ">" :
                return new GreaterThan();
            case "<" :
                return new LessThan();
            case "and" :
                return new And();
            case "or" :
                return new OR();
            case "==" :
                return new DoubleEquals();
            //Add case for newly added operator here
            default :
                return null;
        }
    }
}
