package neetcode.arrays.hashing;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/encode-and-decode-strings/description/
public class EncodeAndDecodeStrings {
    public String encode(List<String> strs) {
        String encodedStr = "";
        for (String str : strs) {
            int length = str.length();
            encodedStr = encodedStr.concat(String.valueOf(length)).concat("#").concat(str);
        }
        return encodedStr;
    }

    public List<String> decode(String str) {
        List<String> decodedString = new ArrayList<>();
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            StringBuilder sb = new StringBuilder();
            while (chars[i] != '#') {
                sb.append(chars[i]);
                i++;
            }
            i++;
            int length = Integer.valueOf(sb.toString());
            int end = i + length;
            StringBuilder s = new StringBuilder();
            while(i < end) {
                s.append(chars[i]);
                i++;
            }
            decodedString.add(s.toString());
            i--;
        }
        return decodedString;
    }
}
