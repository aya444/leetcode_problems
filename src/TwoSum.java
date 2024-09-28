import java.util.HashMap;
import java.util.Map;

class ImprovedSolutionForTwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            // In the first iteration the hash map is empty
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i}; // map.get(currentNum) retrieves the index of the number that corresponds to the currentNum key in the map
            }
            // If not found, put the difference with its index in the map
            map.put(target - nums[i], i);
        }
        return new int[0];
    }
}

class SolutionForTwoSum {
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>();
        int differnce = 0;

        for (int i = 0; i < nums.length; i++) {
            differnce = target - nums[i];
            if (differnce >= 0) {
                map.put(i, differnce);
            }
        }

        for (int j = 0; j < nums.length; j++) {
            int currentNum = nums[j];
            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                if (entry.getValue() == currentNum && entry.getKey() != j) {
                    int index_foundOn = entry.getKey();
                    return new int[]{j, index_foundOn};
                }
            }
        }

        return new int[0];
    }
}

public class TwoSum {
    public static void main(String[] args) throws Exception {
        ImprovedSolutionForTwoSum solution = new ImprovedSolutionForTwoSum();
        int[] num = { 3,2,4 };
        solution.twoSum(num, 6);
    }
}
