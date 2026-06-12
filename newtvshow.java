import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class newtvshow {
    static class Group {
        int value;
        int count;
        int[] dp; // dp[rem] will store 1 for Win, 0 for Lose

        Group(int value, int count) {
            this.value = value;
            this.count = count;
            this.dp = new int[count + 1];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            // Step 1: Sort and Group identical elements
            Arrays.sort(a);
            List<Group> groups = new ArrayList<>();
            int currentVal = a[0];
            int count = 1;
            for (int i = 1; i < n; i++) {
                if (a[i] == currentVal) {
                    count++;
                } else {
                    groups.add(new Group(currentVal, count));
                    currentVal = a[i];
                    count = 1;
                }
            }
            groups.add(new Group(currentVal, count));

            int m = groups.size();

            // Step 2: Calculate DP table states from right to left (backwards induction)
            for (int i = m - 1; i >= 0; i--) {
                int v = groups.get(i).value;
                int c = groups.get(i).count;

                // Check if there is ANY valid larger group that can immediately offer an
                // L-state transition.
                // We do an explicit check of groups to the right to avoid sliding window
                // pointer bugs.
                boolean canWinByJumping = false;
                for (int j = i + 1; j < m; j++) {
                    if (groups.get(j).value > v + k)
                        break; // Out of range

                    // If we jump to group j, we take 1 element, leaving (count - 1) elements.
                    // If that remaining state is an L-state (0), jumping there is a winning move!
                    if (groups.get(j).dp[groups.get(j).count - 1] == 0) {
                        canWinByJumping = true;
                        break;
                    }
                }

                // Evaluate the state for each possible remaining count of elements in group i
                for (int rem = 1; rem <= c; rem++) {
                    boolean canWin = false;

                    if (canWinByJumping) {
                        canWin = true;
                    } else {
                        // Option B: Stay inside the group by taking 1 item
                        if (rem - 1 == 0) {
                            // Taking the last item leaves 0 items. The opponent has no moves and loses, so
                            // we win.
                            canWin = true;
                        } else if (groups.get(i).dp[rem - 1] == 0) {
                            // If leaving (rem - 1) items forces the opponent into an L-state, we win.
                            canWin = true;
                        }
                    }

                    groups.get(i).dp[rem] = canWin ? 1 : 0;
                }
            }

            // Step 3: Check if Arseniy has an opening move that guarantees Egor a win
            boolean egorCanWin = false;
            for (int i = 0; i < m; i++) {
                int v = groups.get(i).value;
                int c = groups.get(i).count;

                // Find if there is an L-state available if Egor is forced to jump from this
                // group
                boolean canEgorWinByJumping = false;
                for (int j = i + 1; j < m; j++) {
                    if (groups.get(j).value > v + k)
                        break;
                    if (groups.get(j).dp[groups.get(j).count - 1] == 0) {
                        canEgorWinByJumping = true;
                        break;
                    }
                }

                // Scenario A: Arseniy takes 1 item from a group with duplicates, leaving c - 1
                // items.
                // Egor wins if the remaining layout is a Winning state (1) for whoever starts.
                if (c > 1 && groups.get(i).dp[c - 1] == 1) {
                    egorCanWin = true;
                    break;
                }

                // Scenario B: Arseniy takes the ONLY item of this group (c == 1).
                // Egor is forced to jump to a larger valid group, so he wins if an L-state is
                // waiting.
                if (c == 1 && canEgorWinByJumping) {
                    egorCanWin = true;
                    break;
                }
            }

            if (egorCanWin) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.print(sb);
    }
}