/**
 *
 * @Description:
 * @author zhiwj
 * @date 2019-10-25 9:18
 */
public class Main {
    public static void main(String[] args) {
        int[][] arr = new int[10][25];

        for(int i=0;i<10;i++){
            arr[i][0] =1;
        }
        for(int j=0;j<25;j++){
            arr[0][j] =1;
        }
        for(int i =1;i<10;i++){
            for(int j=1;j<25;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        System.out.println(arr[9][24]);
    }
}