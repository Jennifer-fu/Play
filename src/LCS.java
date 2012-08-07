public class LCS {

    public String calculate(String str1, String str2) {
//        return recursive(str1, str2, str1.length() - 1, str2.length() - 1);
        return noRecursive(str1, str2);
    }

    private String recursive(String str1, String str2, int i, int j) {
        if (i < 0 || j < 0) return "";
        if (str1.charAt(i) == str2.charAt(j)) return recursive(str1, str2, i - 1, j - 1) + str1.charAt(i);
        String lcs1 = recursive(str1, str2, i, j - 1);
        String lcs2 = recursive(str1, str2, i - 1, j);
        if (lcs1.length() >= lcs2.length()) return lcs1;
        return lcs2;
    }

    private String noRecursive(String str1, String str2){
        String[][] result = new String[str1.length()][str2.length()];
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                if(str1.charAt(i)==str2.charAt(j))
                 result[i][j] = String.valueOf(str1.charAt(i));
                else result[i][j] = "";
            }
        }

        for (int i = 1; i < str1.length(); i++) {
            for (int j = 1; j < str2.length(); j++) {
               if(str1.charAt(i)==str2.charAt(j))result[i][j] = result[i-1][j-1]+str1.charAt(i);
                else {
                   String s1 = result[i][j - 1];
                   String s2 = result[i - 1][j];
                   if(s1.length()>=s2.length())result[i][j] = s1;
                   else result[i][j] = s2;
               }
            }
        }
        return result[str1.length()-1][str2.length()-1];
    }
}
