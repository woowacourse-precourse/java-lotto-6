package lotto.common;

public class Common {

    public static int strToInt(String s){
        int len = s.length();

        if (len > 1) {
            return ((s.charAt(len - 1) - '0')
                    + strToInt(s.substring(0, len - 1)) * 10);
        }
        return s.charAt(0) - '0';
    }
}
