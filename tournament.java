import java.util.*;

public class tournament {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int n = 0;
            int j = 0;
            int k = 0;
            n = sc.nextInt();
            j = sc.nextInt();
            k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            if (k >= 2) {
                System.out.println("yes");
            } else if (k == 1) {
                int m = 1;
                int temp = arr[j - 1];
                for (int q = 0; q < n; q++) {
                    if (arr[q] > temp) {
                        System.out.println("no");
                        m = 0;
                        break;
                    }
                }
                if (m == 1) {
                    System.out.println("Yes");
                }
            }

        }
        sc.close();
    }
}
