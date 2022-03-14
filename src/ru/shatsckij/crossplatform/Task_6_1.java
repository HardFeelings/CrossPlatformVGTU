package ru.shatsckij.crossplatform;

import java.util.Scanner;

public class Task_6_1 {


    static double sum(double x, int n){
        if(n <= 0){
            return 0;
        }
        return sum(x,n-1) + -(Math.pow(x,n)/n);
    }

    static double findSumAbs(double x,double e){
        double sum = 0;
        int n = 1;
        while(true){
            double element = -(Math.pow(x,n)/n);
            if(Math.abs(element) < e){
                return sum;
            }
            sum+= element;
            n++;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите x: ");
        double x = sc.nextDouble();
        if (Math.abs(x) > 1) {
            sc.close();
            throw new IllegalArgumentException("Не удовлетворяет условию");
        }
        System.out.print("Введите кол-во шагов: ");
        int n = sc.nextInt();
        System.out.print("Введите e: ");
        double e = sc.nextDouble();
        System.out.println("Сумма n-слагемых заданного вида: " + sum(x,n));
        System.out.println("Сумма тех слагаемых, которые по абсолютной величине больше e: " + findSumAbs(x,e));
        System.out.println("Сумма тех слагаемых, которые по абсолютной величине больше e/10: " + findSumAbs(x,e/10));
        System.out.println("Значение функции с помощью методов Math: " + Math.log(1-x));
        sc.close();
    }
}
