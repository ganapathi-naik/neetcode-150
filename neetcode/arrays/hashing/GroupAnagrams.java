package neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/description/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String sortedStr = new String(charArray);
            List<String> anagrams = groupedAnagrams.getOrDefault(sortedStr, new ArrayList<>());
            anagrams.add(str);
            groupedAnagrams.put(sortedStr, anagrams);
        }
        return new ArrayList<>(groupedAnagrams.values());
    }
}
