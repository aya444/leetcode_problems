package easy.two_sum;

public class TwoSum {
    public static void main(String[] args){
        ImprovedSolution solution = new ImprovedSolution();
        int[] num = {3, 2, 4};
        int[] result = solution.twoSum(num, 6);
        for (int j : result) System.out.println(j);
    }
}
