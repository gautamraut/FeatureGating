package com.Scaler.Operator;

public class OR extends Operator{
    public OR(){
        precedence = OperatorPrecedence.OR;
    }

    @Override
    public boolean Operate(String[] operands) {
        if(operands.length!= 2)
            throw new IllegalArgumentException("Number of arguments are not proper");
        if(Boolean.parseBoolean(operands[0]) || Boolean.parseBoolean(operands[1]))
            return true;
        return false;
    }
}
