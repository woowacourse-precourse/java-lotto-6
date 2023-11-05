package Validate;

import java.util.IllegalFormatConversionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException {
    private static final String KOREAN_ENGLISH_REGEX = ".*[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*";
    private static final String NOTING_STRING = "";
    private static final String BLANK = " ";
    private static final String SPECIAL_CHARACTER_REGEX = ".*[!@#$%^&*().?\":{}|<>].*";
    private static final Character COMMA_CHAR = ',';

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException("[ERROR] 입력에 문자가 포함되어 있습니다.");
        }
    }

    public static Boolean blankCheck(String strLine) {
        if (!strLine.equals(NOTING_STRING)) {
            return true;
        }
        throw new NumberFormatException("[ERROR] 빈칸은 입력할 수 없습니다.");
    }

    public static void includeBlank(String strLine) {
        if (strLine.contains(BLANK)) {
            throw new NumberFormatException("[ERROR] 입력에 공백이 포함되어 있습니다.");
        }
    }

    public static void includeSpecialString(String strLine) {
        Pattern pattern = Pattern.compile(SPECIAL_CHARACTER_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException("[ERROR] 문자열에 특수 문자가 포함되어 있습니다.");
        }
    }

    public static boolean commaNextBlank(String strLine) {
        int length = strLine.length();

        if (strLine.charAt(length - 1) != COMMA_CHAR || strLine.charAt(0) == ',') {
            return true;
        }

        throw new IllegalArgumentException("[ERROR] 처음 또는 끝이 ',' 입니다.");
    }
}
