import java.util.*;

class CombinationSum3 {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> curr = new ArrayList<Integer>();

            dfs(curr, k, 1, n);

            return ans;
        }

        private void dfs(List<Integer> curr, int k, int idx, int sum) {
            if (sum < 0)  return;
            if (sum == 0 && curr.size() == k) {
                ans.add(new ArrayList<Integer>(curr));
                return;
            
            }
            for (int i=idx; i<=9; i++) {
                curr.add(i);
                dfs(curr, k, i + 1, sum - i);
                curr.remove(curr.size() - 1);
            }
        }

        public static void main(String[] args) {
          CombinationSum3 combinationSum3 = new CombinationSum3();
          System.out.println(combinationSum3.combinationSum3(3, 7));
        }
}
