package Validate;

import java.util.IllegalFormatConversionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException {
    private static final String KOREAN_ENGLISH_REGEX = ".*[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*";
    private static final String NOTING_STRING = "";

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException("입력에 문자가 포함되어 있습니다.");
        }
    }

    public static Boolean blankCheck(String strLine) {
        if (!strLine.equals(NOTING_STRING)) {
            return true;
        }
        throw new NumberFormatException("빈칸은 입력할 수 없습니다.");
    }
}
