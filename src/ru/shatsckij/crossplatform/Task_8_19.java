package ru.shatsckij.crossplatform;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.io.*;

class Corner {
    private int x, y, h, w;

    public Corner(int x, int y) {
        this.x = x;
        this.y = y;

    }

    public void setH(int h) {
        this.h = h;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getH() {
        return h;
    }

    public int getW() {
        return w;
    }

    @Override
    public String toString() {
        return "{ " + y + ", " + x + ", " + h + ", " + w + " }";
    }
}


public class Task_8_19 {

    private static List<Corner> collectCorners(boolean[][] arr) {
        List<Corner> result = new ArrayList<Corner>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == false) continue;
                boolean v = false, h = false;
                if (i == 0) v = true;
                else if (arr[i - 1][j] == false) v = true;
                if (j == 0) h = true;
                else if (arr[i][j - 1] == false) h = true;
                if (v && h) result.add(new Corner(j, i));
            }
        }
        return result;
    }

    private static void getHeigth(boolean[][] arr, Corner pos) {
        int j = pos.getX();
        int i = pos.getY();
        int h = 0;
        while (arr[i][j] == true) {
            h++;
            i++;
            if (i >= arr.length) break;
        }
        pos.setH(h);
    }

    private static void getWidth(boolean[][] arr, Corner pos) {
        int j = pos.getX();
        int i = pos.getY();
        int w = 0;
        while (arr[i][j] == true) {
            w++;
            j++;
            if (j >= arr[i].length) break;
        }
        pos.setW(w);
    }

    private static boolean isRect(boolean[][] arr, Corner pos) {
        for (int i = pos.getY(); i < pos.getY() + pos.getH(); i++) {
            for (int j = pos.getX(); j < pos.getX() + pos.getW(); j++) {
                if (arr[i][j] == false) return false;
            }
        }
        return true;
    }

    private static boolean hasBorder(boolean[][] arr, Corner pos) {
        int j;
        int i;
        j = pos.getX() - 1;
        if (j >= 0)
            for (i = pos.getY(); i < pos.getY() + pos.getH(); i++) {
                if (arr[i][j] == true) return false;
            }
        j = pos.getX() + pos.getW();
        if (j < arr[0].length)
            for (i = pos.getY(); i < pos.getY() + pos.getH(); i++) {
                if (arr[i][j] == true) return false;
            }
        i = pos.getY() - 1;
        if (i >= 0)
            for (j = pos.getX(); j < pos.getX() + pos.getW(); j++) {
                if (arr[i][j] == true) return false;
            }
        i = pos.getY() + pos.getH();
        if (i < arr.length)
            for (j = pos.getX(); j < pos.getX() + pos.getW(); j++) {
                if (arr[i][j] == true) {
                    return false;
                }
            }

        j = pos.getX() - 1;
        i = pos.getY() - 1;
        if (j >= 0 && i >= 0) if (arr[i][j] == true) return false;
        j = pos.getX() + pos.getW();
        if (j < arr[0].length && i >= 0) if (arr[i][j] == true) return false;
        i = pos.getY() + pos.getH();
        if (j < arr[0].length && i < arr.length) if (arr[i][j] == true) return false;
        j = pos.getX() - 1;
        if (j >= 0 && i < arr.length) if (arr[i][j] == true) return false;

        return true;
    }


    public String GetTask(boolean[][] arr){

        List<Corner> corners = collectCorners(arr);
        for (Corner item : corners) {
            getHeigth(arr, item);
            getWidth(arr, item);
        }
        List<Corner> rects = corners.stream().filter(i -> isRect(arr, i)).filter(i -> hasBorder(arr, i)).toList();
        rects = rects.stream().sorted(new Comparator<Corner>() {
            @Override
            public int compare(Corner b, Corner a) {
                int sa = a.getH() * a.getW();
                int sb = b.getH() * b.getW();
                if (sa - sb != 0) return sa - sb;
                if (b.getY() - a.getY() != 0) return b.getY() - a.getY();
                if (b.getX() - a.getX() != 0) return b.getX() - a.getX();
                return 0;
            }
        }).toList();
        return rects.get(0).toString();
    }
}