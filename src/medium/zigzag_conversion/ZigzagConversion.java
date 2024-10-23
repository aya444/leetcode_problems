package medium.zigzag_conversion;

public class ZigzagConversion {
    public static void main(String[] args) {
        String word = "PAYPALISHIRING";
        int rows = 3;
        Solution s = new Solution();
        String result = s.convert(word, rows);
        System.out.println(result);
    }
}
