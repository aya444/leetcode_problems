package medium.zigzag_conversion;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;

        // Create a StringBuilder for each linked list row
        List<StringBuilder> rows = new LinkedList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new StringBuilder());
        }

        // Height is the counter that moves up and down in the zigzag pattern
        int height = 0;

        // Boolean to indicate if we should move up or down in the zigzag
        boolean moveDown = false;

        // Loop over the given string
        for (int i = 0; i < s.length(); i++) {
            // if we reached the end of the column, start moving up the rows else move down
            if (height == 0 || height == numRows - 1)
                moveDown = !moveDown;
            // add the character(i) in that row
            rows.get(height).append(s.charAt(i));
            if (moveDown)
                height += 1;
            else
                height -= 1;
        }

        // Helper function to build the string in all rows
        StringBuilder finalBuilder = new StringBuilder();
        for (StringBuilder stringBuilder : rows) {
            finalBuilder.append(stringBuilder);
        }

        return finalBuilder.toString();
    }
}
