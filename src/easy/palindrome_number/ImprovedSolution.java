package easy.palindrome_number;

public class ImprovedSolution {
    public boolean isPalindrome(int x) {
        if ((x < 0) || (x != 0 && x % 10 == 0))
            return false;

        int original_num = x;
        int reverse_num = 0;

        while (x > 0) {
            reverse_num = reverse_num * 10 + x % 10;
            x /= 10;
        }
        return original_num == reverse_num;
    }
}
