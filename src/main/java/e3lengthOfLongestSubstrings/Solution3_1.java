package e3lengthOfLongestSubstrings;

import java.util.HashMap;

/**
 Runtime O(n) 9 ms Beats 53.56%
 Memory O(m) 45.4 MB Beats 20.30%
 */
public class Solution3_1
{
    /**
     * Explanation: The answer is "abc", with the length of 3.
     *
     * @param s Input: s = "abcabcbb"
     * @return Output: 3
     */
    public int lengthOfLongestSubstring(String s) {
        var count = s.length();
        var length = 0;
        var start = 0;
        var map = new HashMap<Character, Integer>();
        for (var i = 0; i < count; i++) {
            var letter = s.charAt(i);
            if (map.containsKey(letter)) {
                start = Math.max(start,map.get(letter)+1);
            }
            length = Math.max(length,i-start+1);
            map.put(letter, i);
        }
        return length;
    }
}
