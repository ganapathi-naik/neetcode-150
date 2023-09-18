package neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/longest-consecutive-sequence/description/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSeenSoFar = new HashSet<>();
        for (int num : nums) {
            numSeenSoFar.add(num);
        }
        int maxLength = 0;
        for (int num : nums) {
            if (!numSeenSoFar.contains(num - 1)) {
                int length = 0;
                while (numSeenSoFar.contains(num + length)) {
                    length++;
                }
                maxLength = Math.max(maxLength, length);
            }
        }
        return maxLength;
    }
}
