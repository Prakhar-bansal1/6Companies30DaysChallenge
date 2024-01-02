import java.util.*;
public class MinimizingMaxOf2Arrays {

  //greatest common divisor of 2 numbers
  public static int gcd(int a, int b) {
    if(b == 0) return a;
    return gcd(b, a%b);
  } 

  //least common multiple of 2 numbers
  public static int lcm(int a, int b) {
    return a*b / gcd(a, b);
  }

  public static int minimizeSet(int div1, int div2, int uniqueC1, int uniqueC2) {
    //calculating the least common multiple of div1 and div2
    long div = lcm(div1, div2);
    //binary search
    long l = 1, r = 10000000000L;
    while(l < r) {
      long mid = (l + r) /2;
      long count = mid/div1 + mid/div2 - mid/div;
      //counting the number of unique numbers in the range [1, mid] that are divisible by div1 
      long cnt1 = mid/div1 * (div1 -1) + mid % div1;
      //counting the number of unique numbers in the range [1, mid] that are divisible by div2
      long cnt2 = mid/div2 * (div2 - 1) + mid % div2;
      //counting the number of unique numbers in the range [1, mid] that are divisible by div
      long cnt = mid/div * (div -1) + mid % div;
      //if the number of unique numbers in the range [1, mid] that are divisible by div1, div2 and div are greater than or equal to uniqueC1, uniqueC2 and (uniqueC1 + uniqueC2) respectively, then we can minimize the set to mid or less than mid
      if(cnt1 >= uniqueC1 && cnt2 >= uniqueC2 && cnt >= (uniqueC1 + uniqueC2)) {
        r = mid;
      } else { //else we need to minimize the set to greater than mid
        l = mid + 1;
      }
    }
    return (int)l;
  }

  public static void main(String[] args) {
    System.out.println(minimizeSet(2, 7, 1, 3));
  }
}
