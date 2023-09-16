package neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/two-sum/description/
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsSeenSoFar = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numsSeenSoFar.containsKey(target - num)) {
                return new int[]{numsSeenSoFar.get(target - num), i};
            }
            numsSeenSoFar.put(num, i);
        }
        return null;
    }
}
