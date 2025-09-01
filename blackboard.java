import java.util.*;

public class blackboard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int z = 0;
        z = sc.nextInt();
        for (int y = 0; y < z; y++) {

            int n = 0;
            n = sc.nextInt();
            if (n % 4 == 0) {
                System.out.println("bob");
            } else {
                System.out.println("alice");
            }

        }
        sc.close();
    }
}
