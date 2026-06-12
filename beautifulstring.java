import java.util.*;

public class beautifulstring {

    static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    static boolean isNonDecreasing(String s, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            if (s.charAt(i) < s.charAt(i - 1))
                return false;
        }
        return true;
    }

    static boolean isPalindromeAfterRemove(String s, int l, int r) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            if (i >= l && i <= r) {
                i++;
                continue;
            }
            if (j >= l && j <= r) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String s = sc.next();

            if (isPalindrome(s)) {
                System.out.println(0);
                continue;
            }

            int L = 0, R = n - 1;
            while (L < R && s.charAt(L) == s.charAt(R)) {
                L++;
                R--;
            }

            int bestLen = Integer.MAX_VALUE, bestL = -1, bestR = -1;

            // Try removing substrings around mismatch zone [L, R]
            // Expand around L or R
            for (int l = L; l >= 0; l--) {
                for (int r = L; r < n; r++) {
                    if (!isNonDecreasing(s, l, r))
                        continue;
                    if (isPalindromeAfterRemove(s, l, r)) {
                        int len = r - l + 1;
                        if (len < bestLen || (len == bestLen && (l < bestL || (l == bestL && r < bestR)))) {
                            bestLen = len;
                            bestL = l;
                            bestR = r;
                        }
                    }
                }
            }

            for (int l = R; l >= 0; l--) {
                for (int r = R; r < n; r++) {
                    if (!isNonDecreasing(s, l, r))
                        continue;
                    if (isPalindromeAfterRemove(s, l, r)) {
                        int len = r - l + 1;
                        if (len < bestLen || (len == bestLen && (l < bestL || (l == bestL && r < bestR)))) {
                            bestLen = len;
                            bestL = l;
                            bestR = r;
                        }
                    }
                }
            }

            if (bestLen == Integer.MAX_VALUE) {
                System.out.println(-1);
            } else {
                System.out.println(bestLen);
                for (int i = bestL + 1; i <= bestR + 1; i++) {
                    System.out.print(i + (i < bestR + 1 ? " " : ""));
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
