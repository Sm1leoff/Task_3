package com.company;

import javax.swing.*;
import java.util.Stack;

public class RealizationTwo {
    private static boolean symbolCheck(int a)
    {
        return ((a == ((int)'+')) || (a == ((int)'-')) || (a == ((int)'/')) || (a == ((int)'*')));
    }
    public static double result (String arr []){
        Stack<Double> stack = new Stack<Double>();
        double a;
        double b;
        for (int i=0;i<arr.length;i++){
            if (arr[i].length()>=2){
                stack.push(Double.parseDouble(arr[i]));
                continue;
            }
            if (symbolCheck((int)arr[i].charAt(0)))
            {
                b = stack.pop();
                a = stack.pop();
                switch (arr[i].charAt(0))
                {
                    case '+':
                        stack.push(a + b);
                        break;
                    case '-':
                        stack.push(a - b);
                        break;
                    case '*':
                        stack.push(a * b);
                        break;
                    case '/':
                        if (b == 0)
                        {
                            JOptionPane.showMessageDialog(null,"На ноль делить нельзя. Завершение программы.");
                            return 0;
                        }
                        else
                        {
                            stack.push(a / b);
                            break;
                        }
                }
            } else {
                stack.push(Double.parseDouble(String.valueOf(arr[i])));
            }
        }
        return stack.pop();
    }
}
