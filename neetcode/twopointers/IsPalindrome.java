package neetcode.twopointers;

//https://leetcode.com/problems/valid-palindrome/description/
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {

            char leftChar = Character.toLowerCase(s.charAt(left));
            if (!((leftChar >= '0' && leftChar <= '9') || (leftChar >= 'a' && leftChar <= 'z'))) {
                left++;
                continue;
            }

            char rightChar = Character.toLowerCase(s.charAt(right));
            if (!((rightChar >= '0' && rightChar <= '9') || (rightChar >= 'a' && rightChar <= 'z'))) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
