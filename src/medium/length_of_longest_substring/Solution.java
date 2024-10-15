package medium.length_of_longest_substring;

import java.util.*;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Use sliding window technique
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLength = 0;
        int left = 0; // Left pointer of the window

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

        /*  If the character is already in the map and is within the current window
            charIndexMap.containsKey(currentChar) -> this only check if the char was found before
            charIndexMap.get(currentChar) >= left -> this part of the condition is imp as it checks if the found char
            is within the current window or not, as there could be more than two windows in a String */
            if (charMap.containsKey(currentChar) && charMap.get(currentChar) >= left) {
                left = charMap.get(currentChar) + 1; // Move the left pointer to the right of the duplicate character
            }

            // Update/add the current character's index to the map
            charMap.put(currentChar, right);

            // Calculate the length of the current window
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
