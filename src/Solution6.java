public class Solution6 {
    public static String intToString(int x) {
        boolean isNegative = (x < 0);
        StringBuilder sb = new StringBuilder();
        if (x == 0) {
            return "0";
        }
        while (x != 0) {
            sb.append((char) ('0' + (x % 10)));
            x /= 10;
        }
        return sb.append(isNegative ? "-" : "").reverse().toString();
    }

    public static int stringToInt(String s) {
        boolean isNegative = s.startsWith("-");
        if (isNegative) {
            s = s.substring(1);
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + (s.charAt(i) - '0');
        }
        return isNegative ? res * (-1) : res;
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int n = s.length();
        reverse(chars, 0, n - 1);
        reverseWords(chars, n);
        return clean(chars, n);
    }

    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }
        char[] chars = s.toCharArray();
        int n = s.length();
        reverse(chars, 0, n - 1);
        reverseWords(chars, n);
        // System.out.println("----");
        return clean(chars, n);
    }

    public void reverseWords(char[] chars, int n) {
        int i = 0, j = 0;
        while (i < n) {
            while (i < j || i < n && chars[i] == ' ') {
                i++;
            }
            while (j < i || j < n && chars[j] != ' ') {
                j++;
            }
            reverse(chars, i, j - 1);
        }
    }

    public String clean(char[] chars, int n) {
//         i keep the current valid index while the j is the iterator.
        int i = 0, j = 0;
        while (j < n) {
            while (j < n && chars[j] == ' ') {
                j++;
            } // skip the leading space
            while (j < n && chars[j] != ' ') {
                chars[i++] = chars[j++];
            } // keep no space;
            while (j < n && chars[j] == ' ') {
                j++;
            } // skip tailing space;
            if (j < n) {
                chars[i++] = ' ';
            } // keep a white space;
        }
        return new String(chars).substring(0, i);
    }

    public void reverse(char[] chars, int l, int r) {
        while (l < r) {
            char temp = chars[l];
            chars[l] = chars[r];
            chars[r] = temp;
            l++;
            r--;
        }
    }
}
