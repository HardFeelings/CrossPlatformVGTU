package ru.shatsckij.crossplatform;

import ru.shatsckij.utils.Utils;

class Result {
    int count = 0;
}

class Elem {
    Result result = null;
    int digit;

    public Elem(int d) {
        this.digit = d;
    }
}

public class Task_8_23 {
    private static Elem[][] FillGrid(int[][] arr) {
        Elem[][] ret = new Elem[arr.length][arr[0].length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = new Elem(arr[i][j]);
            }
        }
        return ret;
    }

    private static void WalkElem(Elem[][] grid, int x, int y, Result res) {
        if (grid[x][y].result != null)
            return;
        int digit = grid[x][y].digit;
        res.count++;
        grid[x][y].result = res;
        if (x - 1 >= 0) {
            if (grid[x - 1][y].digit == digit) {
                WalkElem(grid, x - 1, y, res);
            }
        }
        if (x + 1 < grid.length) {
            if (grid[x + 1][y].digit == digit) {
                WalkElem(grid, x + 1, y, res);
            }
        }
        if (y + 1 < grid[0].length) {
            if (grid[x][y + 1].digit == digit) {
                WalkElem(grid, x, y + 1, res);
            }
        }
        if (y - 1 >= 0) {
            if (grid[x][y - 1].digit == digit) {
                WalkElem(grid, x, y - 1, res);
            }
        }
        return;
    }

    private static void WalkGrid(Elem[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                Result res = new Result();
                WalkElem(grid, i, j, res);
            }
        }
    }

    private static int[][] UnpackResult(Elem[][] grid) {
        int[][] ret = new int[grid.length][grid[0].length];
        for (int i = 0; i < ret.length; i++) {
            for (int j = 0; j < ret[0].length; j++) {
                ret[i][j] = grid[i][j].result.count - 1;
            }
        }
        return ret;
    }

    public int[][] OutputArray(int[][] Array) {
        Elem[][] grid = FillGrid(Array);
        WalkGrid(grid);
        return UnpackResult(grid);
    }

}
