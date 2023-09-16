package neetcode.arrays.hashing;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/contains-duplicate/description/
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> numsSeenSoFar = new HashSet<>();
        for (int num : nums) {
            if (numsSeenSoFar.contains(num)) {
                return true;
            }
            numsSeenSoFar.add(num);
        }
        return false;
    }
}
