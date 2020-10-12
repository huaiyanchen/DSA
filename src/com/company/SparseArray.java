package com.company;
/**

 *
 * @author chy
 *
 * */
public class SparseArray {
    public static void main(String[] args) {
        //创建二位数组
        int[][] chessArr0 = new int[11][11];
        chessArr0[1][2] = 1;
        chessArr0[2][3] = 2;
        chessArr0[3][4] = 1;

        //输出这个数组
        System.out.printf("普通数组为：\n");
        for (int[] row : chessArr0) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
        //创建稀疏数组
        //找出原数组中的个数
        int sum = 0;
        for (int i = 0; i < chessArr0.length; i++) {
            for (int j = 0; j < chessArr0.length; j++) {
                if (chessArr0[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.printf("原数组中非零个数为：");
        System.out.printf("%d\n", sum);
        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = 11;
        sparseArr[0][1] = 11;
        sparseArr[0][2] = sum;
        //遍历数组放入
        int count = 0;
        for (int i = 0; i < chessArr0.length; i++) {
            for (int j = 0; j < chessArr0.length; j++) {
                if (chessArr0[i][j] != 0) {
                    count++;
                    sparseArr[count][0] =i;
                    sparseArr[count][1] =j;
                    sparseArr[count][2] = chessArr0[i][j];
                }
            }
        }

        //c
        System.out.println();
        System.out.printf("输出稀疏数组：\n");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);
        }
        System.out.println();
        //将稀疏数组恢复为原始的二位数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        //为转化后的数组赋值
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];

        }
        //输出恢复后的二维数组
        System.out.println();
        System.out.printf("恢复后的二维数组:\n");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t", data);
            }
            System.out.println();
        }
    }

}
