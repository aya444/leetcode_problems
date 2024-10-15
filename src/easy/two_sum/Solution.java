package easy.two_sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
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
