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
                nextIndexOfLastMatch = result[nextIndexOfLastMatch-1];
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
            if (j > 0 && origin.charAt(i) != pattern.charAt(j)) {
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
}
