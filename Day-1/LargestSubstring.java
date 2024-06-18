import java.util.HashMap;

public class LargestSubstring {
    public static void main(String[] args) {
        String input = "abcdabcbb";
        String longestSubstring = findLongestSubstring(input);
        System.out.println("The longest substring without repeating characters is: " + longestSubstring);
        System.out.println("The length of the longest substring is: " + longestSubstring.length());
    }

    public static String findLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, maxLength = 0, startIndex = 0;
        HashMap<Character, Integer> seenCharacters = new HashMap<>();

        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map, move the start pointer
            // to the right of the same character's last seen position
            if (seenCharacters.containsKey(currentChar)) {
                start = Math.max(start, seenCharacters.get(currentChar) + 1);
            }

            // Update the character's last seen position
            seenCharacters.put(currentChar, end);

            // Update maxLength and startIndex if a longer substring is found
            if (end - start + 1 > maxLength) {
                maxLength = end - start + 1;
                startIndex = start;
            }
        }

        // Return the longest substring without repeating characters
        return s.substring(startIndex, startIndex + maxLength);
    }
}
