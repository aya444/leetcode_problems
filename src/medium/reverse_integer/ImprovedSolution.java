package medium.reverse_integer;

public class ImprovedSolution {

    /*
      FLow:
        x = 1203
        first iteration -> result = 0 * 10 + 3 = 3
        second iteration -> result = 3 * 10 + 0 = 30
        Third iteration -> result = 30 * 10 + 2 = 302
        Forth iteration -> result = 302 * 10 + 1 =3021
    */

    public int reverse(int x) {
        int result = 0;

        while (x != 0) {
            int digit = x % 10; // get last digit in x
            x /= 10; // remove last digit in x

            // Check for overflow before adding the digit
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0; // Overflow case
            }
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0; // Underflow case
            }

            result = result * 10 + digit;
        }
        return result;
    }

}
