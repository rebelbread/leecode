package test.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-07-12 16:45
 */
public class Queen {

    /**
     * 八皇后
     */

    public static List<int[]> resultList = new ArrayList<>();

    public static void main(String[] args) {
        int[] chess = new int[8];
        put(chess, 0);
        System.out.println(resultList);
    }

    private static void put(int[] chess, int n) {
        if (n == 8) {
            // 结束了 返回结果
            resultList.add(chess.clone());
            return;
        }

        for (int i = 0; i < 8; i++) {
            // 八行 所以放8次
            // n是行 i是列
            chess[n] = i;
            // 判断有没有冲突
            if (judge(chess, n)) {
                // 没有冲突 放下一个
                put(chess, n + 1);
            } else {
                // 有冲突 放弃
            }


        }

    }

    private static boolean judge(int[] chess, int n) {
        // 循环所有比n小的格子 看有没有冲突
        for (int k = 0; k < n; k++) {
            // 在同一列
            if (chess[k] == chess[n]) {
                return false;
            }
            if (Math.abs(n - k) == Math.abs(chess[n] - chess[k])) {
                return false;
            }
        }
        return true;
    }

    private static void print(int[][] arr) {
        System.out.println("----------------");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }
}
