package com.example.dilay.myapplication;

import java.text.DecimalFormat;
import java.util.Stack;

public class Calculator {

    static double findPostfixResult(String exp)
    {

        Stack<Double> stack=new Stack<>();


        for(int i=0;i<exp.length();i++)
        {
            char c=exp.charAt(i);


            if(Character.isDigit(c))
                stack.push((double) Character.getNumericValue(c));
                //stack.push(c - '0');


            else
            {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch(c)
                {
                    case '+':
                        stack.push(val2+val1);
                        break;

                    case '-':
                        stack.push(val2- val1);
                        break;

                    case '/':
                        stack.push(val2/val1);
                        break;

                    case '*':
                        stack.push(val2*val1);
                        break;
                }
            }
        }
        DecimalFormat form=new DecimalFormat("#.#");
        Double result =stack.pop();

        return Double.parseDouble(form.format(result));
    }


}
