package lyq.com.leetcodesolutions.array;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc 题目：输入一个整数N，打印出从1~N*N的N*N矩阵。 
 * 比如N = 3，构成矩阵： 
 * 1,2,3,
 * 8,9,4,
 * 7,6,5,
 * <p>
 * 比如N = 4，构成矩阵： 
 *  1, 2, 3, 4,
 * 12,13,14, 5,
 * 11,16,15, 6,
 * 10, 9, 8, 7,
 * <p>
 * <p>
 * N=5时，构成矩阵： 
 *  1, 2, 3, 4, 5,
 * 16,17,18,19, 6,
 * 15,24,25,20, 7,
 * 14,23,22,21, 8,
 * 13,12,11,10, 9,
 */
public class Algorithm {

    public static void main(String[] args) {
        int n= 5;
        int maxNumLength=String.valueOf(n*n).length();
        int [][] result=algorithm(n);
        //格式化打印输出
        for ( int i=0;i<result.length;i++){
            for(int j=0;j<result[i].length;j++){
                System.out.print(String.format("%"+maxNumLength+"d",result[i][j])+",");
            }
            System.out.println();
        }
    }

    public static int[][] algorithm(int n) {
        int length = n * n;
        int[][] result = new int[n][n];
        int direction = 1;
        int i = 0;
        int j = 0;
        for (int k = 1; k <= length; k++) {
            result[i][j] = k;
            DirectionEnum directionEnum = DirectionEnum.getDirctionByCode(direction % 4);
            switch (directionEnum) {
                case RIGHT:
                    if (j == n - 1 || result[i][j + 1] != 0) {
                        i++;
                        direction++;//改变方向
                    }else{
                        j++;
                    }
                    break;
                case DOWN:
                    if (i == n-1 ||result[i+1][j] != 0){
                        j--;
                        direction++;
                    }else{
                        i++;
                    }
                    break;
                case LEFT:
                    if (j == 0 || result[i][j-1] != 0){
                        i--;
                        direction ++;
                    }else{
                        j--;
                    }
                    break;
                case UP:
                    if (i == 0 ||result[i-1][j] != 0){
                        j++;
                        direction++;
                    }else{
                        i--;
                    }
                    break;
                default:
                    break;
            }
        }

        return result;
    }
}
