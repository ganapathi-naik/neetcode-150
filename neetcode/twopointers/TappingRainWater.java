package neetcode.twopointers;

//https://leetcode.com/problems/trapping-rain-water/
public class TappingRainWater {
    public int trap(int[] height) {
        return trapWithConstantMemory(height);
    }

    public int trapWithConstantMemory(int[] height) {
        int n = height.length;
        int maxLeft = height[0], maxRight = height[n - 1];
        int left = 0, right = n - 1;
        int waterTrapped = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                left++;
                if (maxLeft - height[left] > 0) {
                    waterTrapped += maxLeft - height[left];
                }
                maxLeft = Math.max(maxLeft, height[left]);
            } else {
                right--;
                if (maxRight - height[right] > 0) {
                    waterTrapped += maxRight - height[right];
                }
                maxRight = Math.max(maxRight, height[right]);
            }
        }
        return waterTrapped;
    }

    public int trapWithExtractMemory(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        maxLeft[0] = 0;
        int leftSoFar = height[0];
        for (int i = 1; i < n; i++) {
            maxLeft[i] = leftSoFar;
            leftSoFar = Math.max(leftSoFar, height[i]);
        }

        maxRight[n - 1] = 0;
        int rightSoFar = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = rightSoFar;
            rightSoFar = Math.max(rightSoFar, height[i]);
        }
        int waterTrapped = 0;
        for (int i = 0; i < n; i++) {
            int waterTrappedAtI = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (waterTrappedAtI > 0) {
                waterTrapped += waterTrappedAtI;
            }
        }
        return waterTrapped;
    }
}
