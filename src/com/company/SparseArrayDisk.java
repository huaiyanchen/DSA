package com.company;

import java.awt.*;
import java.io.*;

/**
 * @author chy
 */
public class SparseArrayDisk {
    public static void main(String[] args) throws IOException {
        int[][] chessArr1 = new int[11][11];
        chessArr1[2][3] = 1;
        chessArr1[4][5] = 1;
        int sum = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    sum++;
                }
            }
        }
        System.out.println(sum);

        int[][] sparseArr = new int[sum + 1][3];
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1.length;
        sparseArr[0][2] = sum;

        int count = 0;
        for (int i = 0; i < chessArr1.length; i++) {
            for (int j = 0; j < chessArr1.length; j++) {
                if (chessArr1[i][j] != 0) {
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }
        //save
        File file = new File("E:\\IdeaWorkBench\\DSA\\file\\map.data");
        FileOutputStream fileOutputStream = new FileOutputStream(file);

        OutputStreamWriter writer = new OutputStreamWriter(fileOutputStream, "UTF-8");
        //输出稀疏数组的形式
        System.out.println();
        System.out.println("得到的数组为：");
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n", sparseArr[i][0], sparseArr[i][1], sparseArr[i][2]);

            //save in file
            if (i == sparseArr.length - 1) {
                writer.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + "\r\n");

            } else {
                writer.append(sparseArr[i][0] + "," + sparseArr[i][1] + "," + sparseArr[i][2] + "," + "\r\n");

            }
        }
        System.out.println("writing...");
        writer.close();
        fileOutputStream.close();


        //read from file
        System.out.println("reading...");
        Desktop.getDesktop().open(file);
        System.out.println("read file");
        FileInputStream fileInputStream = new FileInputStream(file);
        InputStreamReader reader = new InputStreamReader(fileInputStream, "UTF-8");
        StringBuffer stringBuffer = new StringBuffer();
        while (reader.ready()) {
            stringBuffer.append((char) reader.read());
        }
        System.out.println(stringBuffer.toString());
        reader.close();
        fileInputStream.close();

        //create sparseArr2
        String[] strings = stringBuffer.toString().split(",");
        int[][] sparseArr2 = new int[strings.length / 3][3];
        int i = 0;
        for (String s : strings) {
            sparseArr2[(i - (i % 3)) / 3][i % 3] = Integer.parseInt(s);
            i++;

        }

        int chessArr22[][] = new int[sparseArr2[0][0]][sparseArr2[0][1]];
        for (int i3 = 1; i3 < sparseArr2.length; i3++) {
            chessArr22[sparseArr2[i3][0]][sparseArr2[i3][1]] = sparseArr2[i3][2];
            System.out.println();
            for (int[] row : chessArr22) {
                for (int data : row) {
                    System.out.printf("%d\t", data);
                }
                System.out.println();
            }

            System.out.println("--------------------------------------------------------恢复完成");

            int chessArr2[][] = new int[sparseArr[0][0]][sparseArr[0][1]];

            // 2. 在读取稀疏数组后几行的数据,并赋给 原始的二维数组 即可.
            for (int i4 = 1; i4 < sparseArr.length; i4++) {
                chessArr2[sparseArr[i4][0]][sparseArr[i4][1]] = sparseArr[i4][2];
            }

            // 输出恢复后的二维数组
            System.out.println();
            System.out.println("恢复后的二维数组");
            for (int[] row : chessArr2) {
                for (int data : row) {
                    System.out.printf("%d\t", data);
                }
                System.out.println();
            }
        }
    }
}
