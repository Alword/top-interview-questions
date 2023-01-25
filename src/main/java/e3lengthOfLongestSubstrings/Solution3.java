package e3lengthOfLongestSubstrings;

import java.util.HashMap;

/**
 * Runtime 5 ms Beats 93.26%
 * Memory 42.5 MB Beats 69.34%
 */
public class Solution3 {
    /**
     * Explanation: The answer is "abc", with the length of 3.
     * Beats
     * 93.26%
     * Beats
     * 69.34%
     * @param s Input: s = "abcabcbb"
     * @return Output: 3
     */
    public int lengthOfLongestSubstring(String s) {
        var count = s.length();
        var maxLength = 0;
        var length = 0;
        var start = 0;
        var map = new HashMap<Character, Integer>();
        for (var i = 0; i < count; i++) {
            var letter = s.charAt(i);
            // new letter
            if (!map.containsKey(letter)) {
                length += 1;
                map.put(letter, i);
                continue;
            }

            // letter before start
            var position = map.get(letter);
            if (position < start) {
                length += 1;
                map.put(letter, i);
                continue;
            }

            // double letter
            maxLength = Math.max(length, maxLength);
            start = position + 1;
            length = i - start + 1;
            map.put(letter, i);
        }
        maxLength = Math.max(length, maxLength);
        return maxLength;
    }
}
