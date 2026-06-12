import java.util.Scanner;

public class gamesontrain {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            int max = 1;
            int min = 6;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if (arr[i] >= max) {
                    max = arr[i];
                }
                if (arr[i] <= min) {
                    min = arr[i];
                }
            }
            System.out.println(max - min + 1);

        }
        sc.close();
    }
}