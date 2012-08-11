public class KMP {

    public int[] next(String pattern) {
        int[] result = new int[pattern.length()];
        result[0] = -1;
        for (int i = 1; i < pattern.length(); i++) {
            char currentChar = pattern.charAt(i);
            int nextIndexOfLastMatch = result[i - 1] + 1;
            char nextCharOfLastMatch = pattern.charAt(nextIndexOfLastMatch);
            while(currentChar != nextCharOfLastMatch && nextIndexOfLastMatch>0){
                nextIndexOfLastMatch = result[result[i - 1]]+1;
                nextCharOfLastMatch = pattern.charAt(nextIndexOfLastMatch);
            }
            if(currentChar == nextCharOfLastMatch)
                result[i] = nextIndexOfLastMatch;
            else result[i] = -1;
        }
        return result;
    }
}
