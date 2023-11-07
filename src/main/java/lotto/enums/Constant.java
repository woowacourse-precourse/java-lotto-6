package lotto.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Constant {
    COUNT_OF_LOTTO_NUMBERS("6"),
    START_RANGE_OF_NUMBER("1"),
    END_RANGE_OF_NUMBER("45"),
    DELIMITER(",");

    public static final Pattern PATTERN_NUMBER = Pattern.compile("(\\+|-)?[1-9][0-9]+");
    public static final Pattern PATTERN_POSITIVE_NUMBER_STEP_1000 = Pattern.compile("(\\+?0)|(\\+?[1-9][0-9]*000)");

    private String content;

    Constant(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Integer getContentToInteger() {
        validateNumber();

        return Integer.parseInt(content);
    }

    private void validateNumber() {
        Matcher numberMatcher = PATTERN_NUMBER.matcher(content);

        if (numberMatcher.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.STRING_CANNOT_CONVERT_TO_INTEGER.getMessage()); // 에러문 추가
        }
    }
}
