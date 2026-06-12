import java.util.*;

public class casinomountain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int count = 0;
            int a = 0;
            int i = 0;
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = sc.nextInt();
            }
            while (i < n) {
                if (arr[i] == 0) {
                    a++;
                    if (a == k && i < n - 1) {
                        count++;
                        a = 0;
                        arr[i + 1] = 1;
                    }
                    if (a == k && i == n - 1) {
                        count++;
                        a = 0;
                    }
                    i++;
                } else if (arr[i] == 1) {
                    a = 0;
                    i++;
                }
            }

            System.out.println(count);
        }
        sc.close();
    }
}
