package medium.longest_palindromic_string;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        String longest = "";

        for (int i = 0; i < s.length(); i++) {
            // Check for odd-length palindromes
            String oddPalindrome = getSubStringAndCheckPalindrome(s, i, i);
            if (oddPalindrome.length() > longest.length()) {
                longest = oddPalindrome;
            }

            // Check for even-length palindromes
            String evenPalindrome = getSubStringAndCheckPalindrome(s, i, i + 1);
            if (evenPalindrome.length() > longest.length()) {
                longest = evenPalindrome;
            }
        }

        return longest;
    }

    // Method to expand around the center and check for palindrome
    // Expand around the center
    private String getSubStringAndCheckPalindrome(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}