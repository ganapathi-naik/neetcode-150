package neetcode.arrays.hashing;

//https://leetcode.com/problems/product-of-array-except-self/description/
public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] postfix = new int[n];
        int product = 1;
        prefix[0] = product;
        for (int i = 1; i < n; i++) {
            product = product * nums[i - 1];
            prefix[i] = product;
        }

        product = 1;
        postfix[n - 1] = product;
        for (int i = n - 2; i >= 0; i--) {
            product = product * nums[i + 1];
            postfix[i] = product;
        }

        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = prefix[i] * postfix[i];
        }
        return res;
    }
}
