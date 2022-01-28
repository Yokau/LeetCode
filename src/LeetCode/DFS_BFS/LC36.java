package LeetCode.DFS_BFS;

//LC36 Valid Sudo
public class LC36 {
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][10];
        int[][] cols = new int[9][10];
        int[][] boxs = new int[9][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int curNumber = board[i][j] - '0';
                if (rows[i][curNumber] == 1) return false;
                if (cols[j][curNumber] == 1) return false;
                if (boxs[j / 3 + (i / 3) * 3][curNumber] == 1) return false;
                rows[i][curNumber] = 1;
                cols[j][curNumber] = 1;
                boxs[j / 3 + (i / 3) * 3][curNumber] = 1;
            }
        }
        return true;
    }
}
