import java.util.*;

public class LetterCombinationsOfPhoneNumber {
    // there are 4^n combinations, where n is the number of digits
    final static char[][] L = {{}, {}, {'a', 'b', 'c'}, 
                               {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'},
                               {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};
    
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<String>();
        int len = digits.length();
        if(len == 0) return new ArrayList<String>();
        bfs(0, len, new StringBuilder(), digits, ans);
        return ans;
    }
    
    public static void bfs(int pos, int len, StringBuilder sb, String digits, List<String> ans) {
        if(pos == len) {
            ans.add(sb.toString());
            return;
        } else {
          // get the letters for the current digit
            char[] letters = L[Character.getNumericValue(digits.charAt(pos))];
            for(int i=0; i<letters.length; i++) {
              // append the letter to the string builder
                bfs(pos+1, len, new StringBuilder(sb).append(letters[i]), digits, ans);
            }
        }
    }

    public static void main(String[] args) {
      LetterCombinationsOfPhoneNumber letterCombinationsOfPhoneNumber = new LetterCombinationsOfPhoneNumber();
      System.out.println(letterCombinationsOfPhoneNumber.letterCombinations("23"));
    }
}

