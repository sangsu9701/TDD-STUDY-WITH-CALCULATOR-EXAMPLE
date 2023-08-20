package org.example;

import java.util.List;

import org.apache.taglibs.standard.lang.jstl.MultiplyOperator;
import org.example.calculate.AdditionOperator;
import org.example.calculate.DivisionOperator;
import org.example.calculate.MultiplicationOperator;
import org.example.calculate.NewArithmeticOperator;
import org.example.calculate.PositiveNumber;
import org.example.calculate.SubtractionOperator;

public class Calculator {

    // AS-IS
    public static int before_calcultor(int operand1, String operator, int operand2){
        if("+".equals(operator)){
            return operand1 + operand2;
        }else if("-".equals(operator)){
            return operand1 - operand2;
        }else if("*".equals(operator)){
            return operand1 * operand2;
        }else if("/".equals(operator)){
            return operand1 / operand2;
        }
        return 0;
    }

    private static final List<NewArithmeticOperator> arithmeticOperators = List.of(new AdditionOperator(), new SubtractionOperator(), new DivisionOperator(), new MultiplicationOperator());

    // TO-BE / AS-IS
    public static int before2_calculate(int operand1, String operator, int operand2){
        return ArithmeticOperator.calculate(operand1, operator, operand2);
    }

    // TO-BE FINAL
    public static int calculate(PositiveNumber operand1, String operator, PositiveNumber operand2){
        return arithmeticOperators.stream()
            .filter(arithmeticOperator -> arithmeticOperator.supports(operator))
            .map(arithmeticOperator -> arithmeticOperator.calculate(operand1, operand2))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("올바른 사칙연산이 아닙니다."));
    }
}
