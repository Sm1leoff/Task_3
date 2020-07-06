package com.company;

import javax.swing.*;
import java.util.Stack;

public class Realization {
    private static boolean pr(int a)
    {
        return ((a == ((int)'+')) || (a == ((int)'-')) || (a == ((int)'/')) || (a == ((int)'*')));
    }
    public static double result (String arr []){
        Work<Double> lol = new Work<>();
        double a;
        double b;
        for (int i=0;i<arr.length;i++){
            if (arr[i].length()>=2){
                lol.addLast(Double.parseDouble(arr[i]));
                continue;
            }
            if (pr((int)arr[i].charAt(0)))
            {
                b = lol.removeAndReturnFirst();
                a = lol.removeAndReturnFirst();
                switch (arr[i].charAt(0))
                {
                    case '+':
                        lol.addLast(a + b);
                        break;
                    case '-':
                        lol.addLast(a - b);
                        break;
                    case '*':
                        lol.addLast(a * b);
                        break;
                    case '/':
                        if (b == 0)
                        {
                            JOptionPane.showMessageDialog(null,"На ноль делить нельзя. Завершение программы.");
                            return 0;
                        }
                        else
                        {
                            lol.addLast(a / b);
                            break;
                        }
                }
            } else {
                lol.addLast(Double.parseDouble(String.valueOf(arr[i])));
            }
        }
        return lol.removeAndReturnFirst();
    }
}
