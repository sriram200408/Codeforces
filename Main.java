import java.io.*;
import java.util.*;

public class Main {

    static class FastScanner {
        private final InputStream in = System.in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0)
                    return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            do {
                c = read();
            } while (c <= ' ');

            int val = 0;
            while (c > ' ') {
                val = val * 10 + c - '0';
                c = read();
            }
            return val;
        }
    }

    public static void main(String[] args) throws Exception {

        FastScanner fs = new FastScanner();
        StringBuilder ans = new StringBuilder();

        int T = fs.nextInt();

        while (T-- > 0) {

            int n = fs.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = fs.nextInt();
            }

            int[][] maxStart = new int[n + 2][n + 2];
            int[][] minEnd = new int[n + 2][n + 2];

            for (int i = 0; i <= n + 1; i++) {
                Arrays.fill(minEnd[i], Integer.MAX_VALUE);
                Arrays.fill(maxStart[i], -1);
            }

            int[] vis = new int[n + 2];
            int timer = 1;

            for (int l = 0; l < n; l++) {

                timer++;

                int mn = a[l];
                int mx = a[l];

                for (int r = l; r < n; r++) {

                    int x = a[r];

                    if (vis[x] == timer)
                        break;
                    vis[x] = timer;

                    if (x < mn)
                        mn = x;
                    if (x > mx)
                        mx = x;

                    int len = r - l + 1;

                    if (mx - mn + 1 == len) {

                        if (l > maxStart[len][mn])
                            maxStart[len][mn] = l;

                        if (r < minEnd[len][mn])
                            minEnd[len][mn] = r;
                    }
                }
            }

            int best = 0;

            for (int len = n; len >= 1; len--) {

                boolean found = false;

                for (int mn = 1; mn + 2 * len - 1 <= n; mn++) {

                    if (maxStart[len][mn] == -1)
                        continue;
                    if (maxStart[len][mn + len] == -1)
                        continue;

                    if (maxStart[len][mn] > minEnd[len][mn + len]
                            || maxStart[len][mn + len] > minEnd[len][mn]) {

                        best = len;
                        found = true;
                        break;
                    }
                }

                if (found)
                    break;
            }

            ans.append(best).append('\n');
        }

        System.out.print(ans);
    }
}