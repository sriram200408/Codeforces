import java.util.*;

public class omskprogrammers {

    static List<long[]> getStates(long n, long x) {
        List<long[]> states = new ArrayList<>();

        long cur = n;
        long cost = 0;

        while (true) {
            states.add(new long[] { cur, cost });

            if (cur == 0)
                break;

            cur /= x;
            cost++;
        }

        return states;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();

            List<long[]> A = getStates(a, x);
            List<long[]> B = getStates(b, x);

            long ans = Long.MAX_VALUE;

            for (long[] s1 : A) {
                long v1 = s1[0];
                long c1 = s1[1];

                for (long[] s2 : B) {
                    long v2 = s2[0];
                    long c2 = s2[1];

                    ans = Math.min(ans,
                            c1 + c2 + Math.abs(v1 - v2));
                }
            }

            System.out.println(ans);
        }

        sc.close();
    }
}