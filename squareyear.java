import java.util.*;

public class squareyear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        sc.nextLine();
        for (int y = 0; y < z; y++) {
            int val = 0;
            String s = sc.nextLine();
            if (s != null && !s.trim().isEmpty()) {
                int num = Integer.parseInt(s);
                if (num == 0) {
                    System.out.println(0 + " " + 0);
                    val = 1;
                }
                if (num > 0 && num < 1000) {
                    for (int i = 1; i < 32; i++) {
                        if (i * i == num) {
                            System.out.println(0 + " " + i);
                            val = 1;
                            break;
                        }
                    }
                } else if (num >= 1000 && num < 5000) {
                    for (int i = 32; i <= 70; i++) {
                        if (i * i == num) {
                            System.out.println(0 + " " + i);
                            val = 1;
                            break;
                        }
                    }
                } else if (num >= 5000 && num < 10000) {
                    for (int i = 71; i < 100; i++) {
                        if (i * i == num) {
                            System.out.println(0 + " " + i);
                            val = 1;
                            break;
                        }
                    }
                }
                if (val == 0) {
                    System.out.println(-1);
                }
            } else {
                System.out.println(-1);
            }

        }
        sc.close();
    }
}
