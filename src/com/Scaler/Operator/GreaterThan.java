package com.Scaler.Operator;

import static com.Scaler.Operator.OperatorInfo.*;

public class GreaterThan extends Operator{
    public GreaterThan(){
        precedence = OperatorPrecedence.GREATER_THAN;
    }

    @Override
    public boolean Operate(String[] operands) {
        if(operands.length!= 2)
            throw new IllegalArgumentException("Number of arguments are not proper");
        if(Integer.parseInt(operands[0]) > Integer.parseInt(operands[1]))
            return true;
        return false;
    }
}
