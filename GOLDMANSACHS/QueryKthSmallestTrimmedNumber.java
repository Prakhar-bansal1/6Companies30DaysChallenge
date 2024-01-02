import java.util.*;

public class QueryKthSmallestTrimmedNumber {
  //trim is the number of digits to be trimmed from the end of each number
  //for example, if trim = 2, then 102 will be trimmed to 10
  //here, we need to find the kth smallest number after trimming the numbers
  //so, we will sort the numbers after trimming them to the last trim digits
  //and then we will find the kth smallest number
  //for example, if nums = ["102", "473", "251", "814"] and trim = 2
  //then after trimming the numbers to the last 2 digits, we will get
  //["02", "73", "51", "14"]
  //after sorting the numbers, we will get
  //["02", "14", "51", "73"]

  public static int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
    int n = nums.length;
    int m = queries.length;
    int ans[] = new int[m];
    //sorting the numbers in ascending order
    String t[][] = new String[n][2];
    for(int i=0; i<m; i++) {
      int k = queries[i][0];
      int trim = queries[i][1];
      for(int j=0; j<n; j++) {
        //trimming the numbers to the last trim digits
        t[j] = new String[]
        //storing the trimmed number and its index using a 2D array 
         {nums[j].substring(nums[j].length() - trim),     String.valueOf(j)};
      }
      //sorting the numbers in ascending order using a custom comparator which compares the trimmed numbers to the last trim digits 
      //How comapration works in Java?
      //If the first string is lexicographically greater than the second string, it returns positive number (difference of character value). If the first string is less than the second string lexicographically, it returns negative number and if the first string is lexicographically equal to the second string then it returns 0.
      Arrays.sort(t, (a, b) -> {
      int x = a[0].compareTo(b[0]);
      //if the trimmed numbers are equal, then we will sort the numbers in ascending order of their indices
      //ternary operator + Integer.valueOf() is used to convert String to Integer
      return x == 0 ? Long.compare(Integer.valueOf(a[1]), Integer.valueOf(b[1])) : x;
      });
      //in this line of code, we are converting the index of the kth smallest number in the sorted array to the index of the kth smallest number in the original array
      ans[i] = Integer.valueOf(t[k - 1][1]);
    }
    return ans;
  }

  public static void main(String[] args) {
    String[] nums = {"102","473","251","814"};
    int[][] queries = {{1,1},{2,3},{4,2},{1,2}};
    System.out.println(Arrays.toString(smallestTrimmedNumbers(nums, queries)));
  }
}
