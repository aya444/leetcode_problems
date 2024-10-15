package easy.palindrome_number;

public class Solution {
    public boolean isPalindrome(int x) {
        boolean flag = false;

        if ((x < 0) || (x == 0))
            return false;

        if (x <= Math.pow(2, 31) - 1) {
            int count = 0;
            int num = x;

            // Count digits in x
            while (num != 0) {
                num /= 10;
                count++;
            }

            // Check if x is palindrome
            if (count != 0) {
                int num_1 = x;
                double num_2 = 0.0;
                double divide_num = Math.pow(10, count - 1);
                for (int i = 0; i < count / 2; i++) {
                    num_2 = num_1 % 10;
                    num_1 /= divide_num;

                    if (num_1 == num_2) {
                        flag = true;
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
        }
        return flag;
    }
}
