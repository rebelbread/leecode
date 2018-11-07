package Array;

import java.util.Arrays;

/**
 * @author zhiwj
 * @date 2018/11/7
 */
public class IsValidSudoku {
    /**
     * 有效的数独
     * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字 1-9 在每一行只能出现一次。
     * 数字 1-9 在每一列只能出现一次。
     * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
     * <p>
     * <p>
     * 上图是一个部分填充的有效的数独。
     * <p>
     * 数独部分空格内已填入了数字，空白格用 '.' 表示。
     * <p>
     * 示例 1:
     * <p>
     * 输入:
     * [
     * ["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     * 示例 2:
     * <p>
     * 输入:
     * [
     * ["8","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: false
     * 解释: 除了第一行的第一个数字从 5 改为 8 以外，空格内其他数字均与 示例1 相同。
     * 但由于位于左上角的 3x3 宫内有两个 8 存在, 因此这个数独是无效的。
     * 说明:
     * <p>
     * 一个有效的数独（部分已被填充）不一定是可解的。
     * 只需要根据以上规则，验证已经填入的数字是否有效即可。
     * 给定数独序列只包含数字 1-9 和字符 '.' 。
     * 给定数独永远是 9x9 形式的。
     */
    public static void main(String[] args) {

        char[][] board = {
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        char[][] board2 = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };


        boolean validSudoku = new IsValidSudoku().isValidSudokuBetter(board);
        System.out.println(validSudoku);
        boolean validSudoku2 = new IsValidSudoku().isValidSudokuBetter(board2);
        System.out.println(validSudoku2);

    }

    public boolean isValidSudoku(char[][] board) {
        // 行
        int[][] lineValid = new int[9][9];
        // 列
        int[][] rowValid = new int[9][9];
        // 块
        int[][] blockValid = new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') {
                    continue;
                }

                //判断行
                int valueIndex = value - '1';
                if (lineValid[i][valueIndex] > 0) {
                    return false;
                }
                //判断列
                if (rowValid[j][valueIndex] > 0) {
                    return false;
                }
                //判断块
                int blockIndex = getBlock(i, j);
//                int cubeX = 3 * (i / 3) + j / 3;
//                int cubeY = 3 * (i % 3) + j % 3;
                if (blockValid[blockIndex][valueIndex] > 0) {
                    return false;
                }
                lineValid[i][valueIndex] = 1;
                rowValid[j][valueIndex] = 1;
                blockValid[blockIndex][valueIndex] = 1;
            }
        }
        return true;
    }

    private int getBlock(int i, int j) {
        switch (i) {
            case 0:
            case 1:
            case 2:
                switch (j) {
                    case 0:
                    case 1:
                    case 2:
                        return 0;
                    case 3:
                    case 4:
                    case 5:
                        return 1;
                    case 6:
                    case 7:
                    case 8:
                        return 2;
                }
            case 3:
            case 4:
            case 5:
                switch (j) {
                    case 0:
                    case 1:
                    case 2:
                        return 3;
                    case 3:
                    case 4:
                    case 5:
                        return 4;
                    case 6:
                    case 7:
                    case 8:
                        return 5;
                }
            case 6:
            case 7:
            case 8:
                switch (j) {
                    case 0:
                    case 1:
                    case 2:
                        return 6;
                    case 3:
                    case 4:
                    case 5:
                        return 7;
                    case 6:
                    case 7:
                    case 8:
                        return 8;
                }
        }
        return -1;
    }

    public boolean isValidSudokuBetter(char[][] board) {

        for (int i = 0; i < 9; i++) {
            int[] row = new int[9];
            int[] col = new int[9];
            int[] cube = new int[9];

            for (int j = 0; j < 9; j++) {
                System.out.println("board[i][j] : [ i=" + i + "j = " + j + "]   -- 值: " + board[i][j]);
                if (board[i][j] != '.') {
                    if (row[board[i][j] - '1'] == 1) {
                        /*System.out.println("====");
                        System.out.println(row[board[i][j]]);
                        System.out.println("====");*/
                        return false;
                    } else {
                        row[board[i][j] - '1'] = 1;
                        System.out.println("row[]   " + Arrays.toString(row) + "  ----   board[i][j] =  " + board[i][j]);
                    }
                }

                if (board[j][i] != '.') {
                    if (col[board[j][i] - '1'] == 1) {
                        return false;
                    } else {
                        col[board[j][i] - '1'] = 1;
                        System.out.println("col[]    " + Arrays.toString(col) + "----  board[j][i] = " + board[j][i]);
                    }
                }
                // 每一宫内行列的变化
                int cubeX = 3 * (i / 3) + j / 3;
                int cubeY = 3 * (i % 3) + j % 3;
                if (board[cubeX][cubeY] != '.') {
                    if (cube[board[cubeX][cubeY] - '1'] == 1) {
                        return false;
                    } else {
                        System.out.println("cubeX= " + cubeX + "   cubeY=" + cubeY);
                        cube[board[cubeX][cubeY] - '1'] = 1;
                        System.out.println("cube[]      " + Arrays.toString(cube) + " ---   board[cubeX][cubeY]   = " + board[cubeX][cubeY]);
                    }
                }
            }

            System.out.println("row[]  " + Arrays.toString(row));
            System.out.println("col[]  " + Arrays.toString(col));
            System.out.println("cube[]  " + Arrays.toString(cube));
        }
        return true;
    }


}
