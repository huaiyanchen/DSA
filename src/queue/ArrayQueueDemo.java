package queue;

import java.util.Scanner;

/**
 * @author chy
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建队列
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("s(exit):退出程序");
            System.out.println("s(add):添加数据到队列");
            System.out.println("s(get):从队列取数据");
            System.out.println("s(head):查看队列头数据");
            key = scanner.next().charAt(0);

        }
    }
}

//使用数组模拟队列

class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;

    //存放数据，模拟队列
    private int[] arr;



    public ArrayQueue(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;

    }

    //判断是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    // 是否为空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加數據
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满 不能加数据");
            return;
        }
        rear++;
        arr[rear] = n;

    }

    //取数据
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空，不能取数据");
        }
        front++;
        return arr[front];
    }

    //显示队列数据
    public void shouQueue() {
        if (isEmpty()) {
            System.out.println("队列空");
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, arr[i]);
        }
    }

    //显示队列的头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列空");
        }
        return arr[front + 1];
    }
}
