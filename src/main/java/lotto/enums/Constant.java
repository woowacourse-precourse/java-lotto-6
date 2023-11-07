package lotto.enums;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum Constant {
    COUNT_OF_LOTTO_NUMBERS("6"),
    START_RANGE_OF_NUMBER("1"),
    END_RANGE_OF_NUMBER("45"),
    NUMBER_USED_TO_ROUND_FIRST_DIGIT("10"),
    NUMBER_USED_TO_MAKE_PERCENTAGE("100"),
    DELIMITER(",");

    public static final Pattern PATTERN_NUMBER = Pattern.compile("(\\+|-)?[0-9]+");
    public static final Pattern PATTERN_FLOAT = Pattern.compile("(\\+|-)?[0-9]+(\\.[0-9]+)?");
    public static final Pattern PATTERN_POSITIVE_NUMBER_AND_1000_UNITS = Pattern.compile("(\\+?0)|(\\+?[1-9][0-9]*000)");

    private String content;

    Constant(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Integer getContentToInteger() {
        validateNumber();

        return Converter.stringToInteger(content);
    }

    public Float getContentToFloat() {
        validateFloat();

        return Converter.stringToFloat(content);
    }

    private void validateNumber() {
        Matcher numberMatcher = PATTERN_NUMBER.matcher(content);

        if (numberMatcher.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.STRING_CANNOT_CONVERT_TO_INTEGER.getMessage()); // 에러문 추가
        }
    }

    private void validateFloat() {
        Matcher floatMatcher = PATTERN_FLOAT.matcher(content);

        if (floatMatcher.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.STRING_CANNOT_CONVERT_TO_FLOAT.getMessage());
        }
    }
}
