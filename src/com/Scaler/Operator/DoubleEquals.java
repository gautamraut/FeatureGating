package com.Scaler.Operator;

public class DoubleEquals extends Operator{
    public DoubleEquals(){
        precedence = OperatorPrecedence.DOUBLE_EQUALS;
    }

    @Override
    public boolean Operate(String[] operands) {
        if(operands.length!= 2)
            throw new IllegalArgumentException("Number of arguments are not proper");
        if(operands[0].equals(operands[1]))
            return true;
        return false;
    }
}
