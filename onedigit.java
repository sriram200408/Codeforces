import java.util.*;

public class onedigit {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int x = sc.nextInt();
            if (x < 10) {
                System.out.println(x);
            } else if (x == 1000) {
                System.out.println(0);
            } else if (x >= 10 && x < 100) {
                int a = x % 10;
                int b = x / 10;
                System.out.println(Math.min(a, b));
            } else {
                int a = x % 10;
                x = x / 10;
                int b = x % 10;
                int c = x / 10;
                b = Math.min(a, b);
                System.out.println(Math.min(c, b));
            }
        }
        sc.close();
    }
}
