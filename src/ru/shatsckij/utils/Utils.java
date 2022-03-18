package ru.shatsckij.utils;

public class Utils<T> {
    public void print2dArray(T[][] inpArray) {
        for (int i = 0; i < inpArray.length; i++) {
            for (int j = 0; j < inpArray[0].length; j++) {
                System.out.print(inpArray[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public <T>void printArray(T[] inpArray){
        for (int i = 0; i < inpArray.length; i++) {
            System.out.print(inpArray[i] +" ");
        }
    }

}
