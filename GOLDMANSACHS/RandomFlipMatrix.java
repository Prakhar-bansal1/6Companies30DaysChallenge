import java.util.*;

class RandomFlipMatrix {
      class Solution {
          int n_rows;
          int n_cols;
          int remaining;
          Map<Integer, Integer> map;
          Random random;
      
          //this function is used to initialize the class
          public Solution(int n_rows, int n_cols) {
              this.n_rows = n_rows;
              this.n_cols = n_cols;
              remaining = n_rows * n_cols;
              map = new HashMap<Integer, Integer>();
              random = new Random();
          }
      
          //this function is used to flip the matrix
          public int[] flip() {
            //generate a random number between 0 and remaining
              int randNum = random.nextInt(remaining);
              //decrement remaining but why? => because we are going to swap the random number with the last number
              remaining--;
              //get the value of the random number from the map
              int index = map.getOrDefault(randNum, randNum);
              //get the value of the last number from the map
              int value = map.getOrDefault(remaining, remaining);
              //swap the random number with the last number
              map.put(randNum, value);
              //return the row and column of the random number
              int[] rowColumn = {index / n_cols, index % n_cols};
              return rowColumn;
          }
      
          //this function is used to reset the matrix
          public void reset() {
              map.clear();
              remaining = n_rows * n_cols;
          }
      }

    public static void main(String[] args) {
      RandomFlipMatrix randomFlipMatrix = new RandomFlipMatrix();
      RandomFlipMatrix.Solution solution = randomFlipMatrix.new Solution(2, 3);
      System.out.println(Arrays.toString(solution.flip()));
    }
}
