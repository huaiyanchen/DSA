import java.util.Scanner;

/**
 * @author chy
 */
public class douTu {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        char i = sa.next().charAt(0);
        System.out.println(i);
    }
}

class douTu2 {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        char i = sa.nextLine().charAt(0);
        System.out.println(i);
    }
}
class douTu3 {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
       String s = sa.nextLine();
        System.out.println(s);
    }
}

//next（）方法只输出了字符串中的第一个字母I，因为接下来的空格它识别不了。
//
//而nextLine（）方法输出了整个字符串，因为该方法可以识别字符串中的空格以及回车，是不是很强大。

class douTu4 {
    public static void main(String[] args) {
        Scanner sa = new Scanner(System.in);
        String s = sa.next();
        System.out.println(s);
    }
}
