import java.util.*;

public class letterhome {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int n = sc.nextInt();
            int s = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            if (n == 1) {
                System.out.println(Math.abs(s - arr[0]));
            } else if (s > arr[0] && s < arr[n - 1]) {
                int diff = Math.min(Math.abs(s - arr[0]), Math.abs(arr[n - 1] - s));
                System.out.println(diff + (arr[n - 1] - arr[0]));
            } else {
                if (s <= arr[0]) {
                    System.out.println(arr[n - 1] - s);
                } else if (s >= arr[n - 1]) {
                    System.out.println(s - arr[0]);
                }

            }
        }
        sc.close();
    }
}
