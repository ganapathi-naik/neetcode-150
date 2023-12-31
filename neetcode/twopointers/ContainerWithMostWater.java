package neetcode.twopointers;

//https://leetcode.com/problems/container-with-most-water/description/
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0, right = n - 1;
        int maxArea = 0;
        while (left < right) {
            int area = (right - left) * Math.min(height[left], height[right]);
            maxArea = Math.max(area, maxArea);
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
