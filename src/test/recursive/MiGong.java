package test.recursive;

/**
 * @author zhiwj
 * @Description:
 * @date 2020-07-12 15:03
 */
public class MiGong {

    /**
     * 迷宫找路
     * 1 1 1 1 1 1 1 1
     * 1 X 0 0 0 0 0 1
     * 1 0 0 0 0 0 0 1
     * 1 1 1 0 0 0 0 1
     * 1 0 0 0 0 0 0 1
     * 1 0 0 0 0 0 0 1
     * 1 0 0 0 0 0 0 1
     * 1 1 1 1 1 1 1 1
     *
     *
     * @param args
     */

    public static void main(String[] args) {
        int[][] arr = getMap();
        print(arr);
        boolean b = setWay(arr, 1, 1);
        System.out.println(b);
        print(arr);


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

    /**
     * 开始的点是 1,1 找到 6,5 就算结束
     * 迷宫的值  0没走过  1墙  2走过了  3死路
     * 策略  下-> 右 ->  上 -> 左
     * @param arr
     * @param i
     * @param j
     */
    private static boolean setWay(int[][] arr, int i, int j) {
        if (arr[6][5] == 2) {
            // 到终点
            return true;
        } else {
            // 当前的路是不是没走过
            if (arr[i][j] == 0) {
                // 没走过
                // 下-> 左 ->  上 -> 右 策略
                arr[i][j] = 2;
                if (setWay(arr, i + 1, j)) {
                    return true;
                } else if (setWay(arr, i, j + 1)) {
                    return true;
                } else if (setWay(arr, i - 1, j)) {
                    return true;
                } else if (setWay(arr, i, j - 1)) {
                    return true;
                } else {
                    arr[i][j] = 3;
                    return false;
                }
            } else {
                // 走过了或者是墙
                return false;
            }
        }
    }

    private static int[][] getMap() {
        int[][] arr = {
                {1, 1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 0, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1, 1},
        };
        return arr;
    }

}
