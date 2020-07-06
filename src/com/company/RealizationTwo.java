package com.company;

import javax.swing.*;
import java.util.Stack;

public class RealizationTwo {
    private static boolean pr(int a)
    {
        return ((a == ((int)'+')) || (a == ((int)'-')) || (a == ((int)'/')) || (a == ((int)'*')));
    }
    public static double result (String arr []){
        Stack<Double> lol = new Stack<Double>();
        double a;
        double b;
        for (int i=0;i<arr.length;i++){
            if (arr[i].length()>=2){
                lol.push(Double.parseDouble(arr[i]));
                continue;
            }
            if (pr((int)arr[i].charAt(0)))
            {
                b = lol.pop();
                a = lol.pop();
                switch (arr[i].charAt(0))
                {
                    case '+':
                        lol.push(a + b);
                        break;
                    case '-':
                        lol.push(a - b);
                        break;
                    case '*':
                        lol.push(a * b);
                        break;
                    case '/':
                        if (b == 0)
                        {
                            JOptionPane.showMessageDialog(null,"На ноль делить нельзя. Завершение программы.");
                            return 0;
                        }
                        else
                        {
                            lol.push(a / b);
                            break;
                        }
                }
            } else {
                lol.push(Double.parseDouble(String.valueOf(arr[i])));
            }
        }
        return lol.pop();
    }
}