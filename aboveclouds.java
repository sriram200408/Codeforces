import java.util.*;

public class aboveclouds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();

        for (int y = 0; y < z; y++) {
            int n = sc.nextInt();
            sc.nextLine();
            String s = sc.nextLine();
            int del = 0;
            for (int i = 1; i < n - 1; i++) {
                char ch = s.charAt(i);
                String sub = s.substring(0, i) + s.substring(i + 1);
                if (sub.indexOf(ch) != -1) {
                    System.out.println("Yes");
                    del = 1;
                    break;
                }
            }
            if (del == 0) {
                System.out.println("NO");
            }
        }
        sc.close();
    }
}
