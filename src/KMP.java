import java.util.ArrayList;

public class KMP {

    public int[] next(String pattern) {
        int[] result = new int[pattern.length()];
        result[0] = 0;
        for (int i = 1; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            int nextIndexOfLastMatch = result[i - 1];
            char nextCharOfLastMatch = pattern.charAt(nextIndexOfLastMatch);
            while (currentChar != nextCharOfLastMatch && nextIndexOfLastMatch > 1) {
                nextIndexOfLastMatch = result[nextIndexOfLastMatch - 1];
                nextCharOfLastMatch = pattern.charAt(nextIndexOfLastMatch);
            }
            if (currentChar == nextCharOfLastMatch)
                result[i] = nextIndexOfLastMatch + 1;
            else result[i] = 0;
        }
        return result;
    }

    public ArrayList<Integer> kmp(String origin, String pattern) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int[] next = next(pattern);
        int j = 0, i = 0;
        while (i < origin.length() && j < pattern.length()) {
            if (j == 0 && origin.charAt(i) != pattern.charAt(j)) i++;
            else if (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
                j = next[j - 1];
            } else {
                j++;
                i++;
            }
            if (j == pattern.length()) {
                result.add(i - j);
                j = next[j - 1];
            }
        }
        return result;
    }

    public String longestCommonSubstring(String lhs, String rhs) {

        int lLength = lhs.length();
        int rLength = rhs.length();

        int length = lLength >= rLength ? rLength : lLength;
        String shortString = lLength >= rLength ? rhs : lhs;
        String longString = lLength >= rLength ? lhs : rhs;

        int max = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                ArrayList<Integer> kmp = kmp(longString, shortString.substring(i, j + 1));
                if (kmp.size() > 0 && j + 1 - i > max) {
                    max = j + 1 - i;
                    start = i;
                    end = j + 1;
                }
            }
        }
        return shortString.substring(start, end);
    }
}
