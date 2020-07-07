package com.company;

import javax.swing.*;
import java.util.Stack;

public class Realization {
    private static boolean symbolCheck(int a)
    {
        return ((a == ((int)'+')) || (a == ((int)'-')) || (a == ((int)'/')) || (a == ((int)'*')));
    }
    public static double result (String arr []){
        Work<Double> stack = new Work<>();
        double a;
        double b;
        for (int i=0;i<arr.length;i++){
            if (arr[i].length()>=2){
                stack.addLast(Double.parseDouble(arr[i]));
                continue;
            }
            if (symbolCheck((int)arr[i].charAt(0)))
            {
                b = stack.removeAndReturnFirst();
                a = stack.removeAndReturnFirst();
                switch (arr[i].charAt(0))
                {
                    case '+':
                        stack.addLast(a + b);
                        break;
                    case '-':
                        stack.addLast(a - b);
                        break;
                    case '*':
                        stack.addLast(a * b);
                        break;
                    case '/':
                        if (b == 0)
                        {
                            JOptionPane.showMessageDialog(null,"На ноль делить нельзя. Завершение программы.");
                            return 0;
                        }
                        else
                        {
                            stack.addLast(a / b);
                            break;
                        }
                }
            } else {
                stack.addLast(Double.parseDouble(String.valueOf(arr[i])));
            }
        }
        return stack.removeAndReturnFirst();
    }
}
