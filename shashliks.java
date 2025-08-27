import java.util.*;

public class shashliks {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int z = 0;
    z = sc.nextInt();

    for (int l = 0; l < z; l++) {

      int k = 0;
      int a = 0;
      int b = 0;
      int x = 0;
      int y = 0;
      int ans = 0;

      int minuse = 0;

      int count = 0;
      k = sc.nextInt();
      a = sc.nextInt();
      b = sc.nextInt();
      x = sc.nextInt();
      y = sc.nextInt();
      if (x < y) {
        minuse = x;
      } else {
        minuse = y;
      }
      while (k >= a || k >= b) {
        if (k >= a && k >= b) {
          count = (k - Math.max(a, b)) / minuse + 1;
          k -= count * minuse;
          ans += count;

        } else if (k >= a) {
          count = (k - a) / x + 1;
          k -= count * x;
          ans += count;
        } else if (k >= b) {
          count = (k - b) / y + 1;
          k -= count * y;
          ans += count;
        } else {
          break;
        }
      }
      System.out.println(ans);
    }

    sc.close();

  }
}
