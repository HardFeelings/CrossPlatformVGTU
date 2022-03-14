package ru.shatsckij.crossplatform;

import java.util.Scanner;

public class TaskFive {

    public static void printTriangle(int h) {
        double col;
        if (h % 2 == 0) col = h * 2;
        else col = (h * 2) - 1;
        int needCol = (int) Math.floor(col / 2);
        int middle = 0;
        for (int line = 0; line < h; line++) {
            String str = "";
            String leftSide = "";
            if (line < Math.round((double) h / 2)) {
                middle = line;
            } else {
                middle = middle - 1;
            }
            String rightSide = "";
            int num = 0;
            for (int colIndex = 0; colIndex < needCol; colIndex++) {
                if (colIndex < line) {
                    leftSide = leftSide + ' ';
                    rightSide = ' ' + rightSide;
                } else {
                    leftSide = leftSide + num;
                    rightSide = num + rightSide;
                    if (line > num) {
                        num = num + 1;
                    }
                }
                str = leftSide + middle + rightSide;
            }
            System.out.println(str);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите высоту(h>=1; h % 2 != 0): ");
        int h;
        try {
            h = sc.nextInt();
            if (h < 1 || h % 2 == 0) {
                throw new RuntimeException();
            }
        } catch (RuntimeException re) {
            h = 0;
            System.out.println("Не удовлетворяет условию");
        }

        printTriangle(h);

        sc.close();
        System.out.println();
    }
}