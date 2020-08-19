package com.Scaler.Operator;

import static com.Scaler.Operator.OperatorInfo.*;

public class And extends Operator{
    public And() {
        precedence = OperatorPrecedence.AND;
    }

    @Override
    public boolean Operate(String[] operands) {
        if(operands.length!= 2)
            throw new IllegalArgumentException("Number of arguments are not proper");
        System.out.println("For And operator Op1: " + operands[0] + " Op2: "+ operands[1]);
        if(Boolean.parseBoolean(operands[0]) & Boolean.parseBoolean(operands[1]))
            return true;
        return false;
    }
}
