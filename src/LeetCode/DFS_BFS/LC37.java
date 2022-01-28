package LeetCode.DFS_BFS;

public class LC37 {
    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    public boolean backTrack(char[][] board, int i, int j) {
        int m = 9;
        if (j >= m) return backTrack(board, i + 1, 0);
        if (i >= m) return true;
        if (board[i][j] != '.') return backTrack(board, i, j + 1);
        for (char c = '1'; c <= '9'; c++) {
            if (!isValid(board, i, j, c)) continue;
            board[i][j] = c;
            if (backTrack(board, i, j + 1)) return true;
            board[i][j] = '.';
        }
        return false;
    }

    public boolean isValid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            if (board[i][k] == ch) return false;
            if (board[k][j] == ch) return false;
            if (board[(i / 3) * 3 + k / 3][(j / 3) * 3 + k % 3] == ch) return false;
        }
        return true;
    }
}
