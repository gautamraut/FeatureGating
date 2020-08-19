package com.Scaler.Operator;

import java.util.*;

enum OperatorPrecedence {
    GREATER_THAN,
    LESS_THAN,
    AND,
    DOUBLE_EQUALS,
    LESS_EQUALS,
    GREATER_EQUALS,
    //Add new operator here...
    INVALID;
}

public class OperatorInfo
{
    static Set operatorsList = new HashSet();

    public static Set GetOperatorsList() {
        operatorsList.add("<");
        operatorsList.add(">");
        operatorsList.add("and");
        return operatorsList;
    }
}


