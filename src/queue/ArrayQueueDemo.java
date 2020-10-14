package queue;

import java.util.Scanner;

/**
 * @author chy
 * 目前数组使用一次就不能使用了 ，没有达到复用效果
 * 将数组使用算法 改进成环形队列 取模：%
 */
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //测试
        //创建队列
        ArrayQueue queue = new ArrayQueue(3);
        char key ;
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        //输出一个菜单
        while (loop) {
            System.out.println("s(show):显示队列");
            System.out.println("e(exit):退出程序");
            System.out.println("a(add):添加数据到队列");
            System.out.println("g(get):从队列取数据");
            System.out.println("h(head):查看队列头数据");
            //接收一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数：");
                    int va = scanner.nextInt();
                    queue.addQueue(va);
                    break;
                case 'g':
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    //查看队列头
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出");
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
    public void showQueue() {
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
