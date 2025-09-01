import java.util.*;

public class bitstring {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = sc.nextInt();
        for (int y = 0; y < z; y++) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            StringBuilder bitstring = new StringBuilder();

            for (int i = 0; i < k; i++) {
                bitstring.append("1");
            }
            for (int i = 0; i < n - k; i++) {
                bitstring.append("0");
            }
            String output = bitstring.toString();
            System.out.println(output);

        }
        sc.close();
    }
}
