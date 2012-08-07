public class LCS {

    public String calculate(String str1, String str2) {
        return lcs(str1, str2, str1.length() - 1, str2.length() - 1);
    }

    private String lcs(String str1, String str2, int i, int j) {
        if (i < 0 || j < 0) return "";
        if (str1.charAt(i) == str2.charAt(j)) return lcs(str1, str2, i - 1, j - 1) + str1.charAt(i);
        String lcs1 = lcs(str1, str2, i, j - 1);
        String lcs2 = lcs(str1, str2, i - 1, j);
        if (lcs1.length() >= lcs2.length()) return lcs1;
        return lcs2;
    }


}
