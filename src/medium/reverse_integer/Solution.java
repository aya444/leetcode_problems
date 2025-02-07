package medium.reverse_integer;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int reverse(int x) {
        if (x == 0) return 0; // handle case x = 0

        boolean flag = (x >= 0); // carry sign of the x

        Queue<Integer> list = new LinkedList<>(); // FIFO

        x = Math.abs(x);
        int digitToBeAddedToQueue;

        while (x > 0) {
            digitToBeAddedToQueue = x % 10; // get last digit
            x = x / 10; // remove the last digit from x
            list.add(digitToBeAddedToQueue);
        }

        StringBuilder finalBuilder = new StringBuilder();
        while (!list.isEmpty()) {
            finalBuilder.append(list.poll());
        }

        int result = 0;
        try {
            result = Integer.parseInt(finalBuilder.toString()); // Attempt conversion
        } catch (NumberFormatException e) {
            return 0; // Overflow case
        }

        return flag ? result : -result;
    }
}
