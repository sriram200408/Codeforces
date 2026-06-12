import java.util.Scanner;
import java.util.Arrays;

public class beautifulaverage {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int size = sc.nextInt();
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = sc.nextInt();

            }
            Arrays.sort(arr);

            System.out.println(arr[size - 1]);
        }
        sc.close();
    }
}
