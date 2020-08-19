package com.Scaler.Operator;

import java.util.*;

enum OperatorPrecedence {
    GREATER_THAN,
    LESS_THAN,
    AND,
    OR,
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
        operatorsList.add("or");
        operatorsList.add("==");
        //Populate newly added operator here
        return operatorsList;
    }
}


