package Validate;

import java.util.IllegalFormatConversionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateException {
    private static final String KOREAN_ENGLISH_REGEX = ".*[a-zA-Zㄱ-ㅎㅏ-ㅣ가-힣].*";

    public static void includeString(String strLine) {
        Pattern pattern = Pattern.compile(KOREAN_ENGLISH_REGEX);
        Matcher matcher = pattern.matcher(strLine);

        if (matcher.matches()) {
            throw new NumberFormatException("입력에 문자가 포함되어 있습니다.");
        }
    }
}
