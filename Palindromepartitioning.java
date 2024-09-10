import java.util.List;
import java.util.ArrayList;

public class Palindromepartitioning{
    public static void main(String[] args) {
        // Create an instance of the Solution class
        Solution solution = new Solution();
        
        // Define the input string
        String s = "aab";
        
        // Call the partition method and store the result
        List<List<String>> result = solution.partition(s);
        
        // Print the result
        System.out.println("Palindrome partitions of the string \"" + s + "\":");
        for (List<String> partition : result) {
            System.out.println(partition);
        }
    }
}

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        func(0, s, path, result);
        return result;
    }

    void func(int index, String s, List<String> path, List<List<String>> result) {
        if (index == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                path.add(s.substring(index, i + 1));
                func(i + 1, s, path, result);
                path.remove(path.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
