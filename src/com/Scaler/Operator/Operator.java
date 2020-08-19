package com.Scaler.Operator;

import static com.Scaler.Operator.OperatorInfo.*;
abstract public class Operator {
    public int GetPrecedence(){
        return precedence.ordinal();
    }

    abstract public boolean Operate(String[] operands);
    protected OperatorPrecedence precedence = OperatorPrecedence.INVALID;
}
