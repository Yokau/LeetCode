package LeetCode.DFS_BFS;

import java.util.ArrayList;
import java.util.List;

public class LC51 {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        if (n == 0) return res;

        //Available Position
        List<StringBuffer> path = new ArrayList<>();
        //Current Row Position
        List<String> curPos = new ArrayList<>();
        // Make a copy of the checkerboard, Simulate the process of calculate
        char[][] pro = new char[0][];

        dfs(res, n, 0, pro);
        return res;
    }

    public void dfs(List<List<String>> res, int n, int index,char[][] pro) {
        if (index == n) {

        }
        char[] rowStr = pro[index];
        int []posOfQueen = new int[2];
        posOfQueen[0] = index;
        for (int i = 0; i < n; i++) {
            if (rowStr[i] != 'S') {  //Seek out a position not occupied by the queen
                rowStr[i] = 'Q';    //The queen occupy this position
                posOfQueen[1] = i;  // Column Of Queen
                break;              //Jump out this loop
            }
        }
        //To take the queen's rightful place
        // Column is colPos and Row is Index
        int row = index;
        int colPlus = posOfQueen[1];
        int colSub = posOfQueen[1];
        while (row < n) {
            if (colPlus < n)
                pro[row++][colPlus++] = 'S';
            if (colSub > 0)
                pro[row++][colSub--] = 'S';
        }
        dfs(res, n, index + 1, pro);
        // Recall the process
        for(char i : rowStr){
            if(rowStr[i] == 'Q')
                rowStr[i] = '.';
        }
        row = index;
        colPlus = posOfQueen[1];
        colSub = posOfQueen[1];
        while (row < n) {
            if (colPlus < n)
                pro[row++][colPlus++] = '.';
            if (colSub > 0)
                pro[row++][colSub--] = '.';
        }

    }
}
