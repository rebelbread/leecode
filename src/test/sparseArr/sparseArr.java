package test.sparseArr;

import java.util.Arrays;

/**
 * @author zhiwj
 * @Description: 稀疏数组
 * @date 2020-06-25 14:17
 */
public class sparseArr {

    public static void main(String[] args) {
        int[][] srcArr = getSrcArr();
        int[][] sparseArr = transToSparseArr(srcArr);
        int[][] revertArr = revert(sparseArr);

        print(srcArr);
        print(sparseArr);
        print(revertArr);

        System.out.println(Arrays.equals(srcArr, revertArr));
    }

    private static int[][] revert(int[][] sparseArr) {
        int line = sparseArr[0][0];
        int column = sparseArr[0][1];
        int[][] srcArr = new int[line][column];
        for (int i = 1; i < sparseArr.length; i++) {
            int[] valueArr = sparseArr[i];
            srcArr[valueArr[0]][valueArr[1]] = valueArr[2];
        }

        return srcArr;
    }

    private static int[][] transToSparseArr(int[][] srcArr) {
        // 先遍历原数组 得到稀疏数组的大小
        int count = 0;
        for (int i = 0; i < srcArr.length; i++) {
            int[] ints = srcArr[i];
            for (int j = 0; j < ints.length; j++) {
                int anInt = ints[j];
                if (anInt > 0) {
                    count++;
                }
            }

        }
        int[][] sparseArr = new int[count + 1][3];
        // 第一行是原数组的行列数据
        sparseArr[0][0] = srcArr.length;
        sparseArr[0][1] = srcArr[0].length;
        sparseArr[0][2] = count;
        int index = 0;
        for (int i = 0; i < srcArr.length; i++) {
            int[] ints = srcArr[i];
            for (int j = 0; j < ints.length; j++) {
                int value = ints[j];
                if (value > 0) {
                    index++;
                    sparseArr[index][0] = i;
                    sparseArr[index][1] = j;
                    sparseArr[index][2] = value;
                    if (index == count) {
                        // 已经封装结束
                        return sparseArr;
                    }
                }
            }
        }


        return sparseArr;
    }

    private static int[][] getSrcArr() {
        int[][] srcArr = {
                {0,0,0,0,0,0,0,0},
                {0,1,0,0,0,0,0,0},
                {0,0,2,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
                {0,0,0,0,0,0,0,0},
        };
        return srcArr;
    }

    private static void print(int[][] arr) {
        System.out.println("---------");
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println("\n");
        }
        System.out.println("---------");
    }

}
