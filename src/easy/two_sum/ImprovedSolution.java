package easy.two_sum;

import java.util.HashMap;
import java.util.Map;

public class ImprovedSolution {
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
