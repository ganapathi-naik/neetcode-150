package neetcode.arrays.hashing;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/valid-anagram/description/
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> sCharFrequency = new HashMap<>();
        Map<Character, Integer> tCharFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sCharFrequency.put(s.charAt(i), sCharFrequency.getOrDefault(s.charAt(i), 0) + 1);
            tCharFrequency.put(t.charAt(i), tCharFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }
        return sCharFrequency.equals(tCharFrequency);
    }
}
