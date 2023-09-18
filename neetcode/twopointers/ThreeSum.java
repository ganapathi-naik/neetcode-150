package neetcode.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/3sum/description/
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                twoSum(nums, i, i + 1, n - 1, res, 0 - nums[i]);
            }
        }
        return res;
    }

    private void twoSum(int[] nums, int firstValIndex, int left, int right, List<List<Integer>> res, int target) {
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                res.add(Arrays.asList(nums[firstValIndex], nums[left], nums[right]));
                do {
                    left++;
                } while (left < right && nums[left] == nums[left - 1]);
                do {
                    right--;
                } while (left < right && nums[right] == nums[right + 1]);
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
}
