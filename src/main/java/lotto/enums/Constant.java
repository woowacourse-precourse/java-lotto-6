package lotto.enums;

import java.util.regex.Pattern;
import lotto.utils.Converter;

public enum Constant {
    COUNT_OF_LOTTO_NUMBERS("6"),
    START_RANGE_OF_NUMBER("1"),
    END_RANGE_OF_NUMBER("45"),
    NUMBER_USED_TO_ROUND_FIRST_DIGIT("10"),
    NUMBER_USED_TO_MAKE_PERCENTAGE("100"),
    MONEY_UNITS("1000"),
    DELIMITER(",");

    public static final Pattern PATTERN_NUMBER = Pattern.compile("(\\+|-)?[0-9]+");
    public static final Pattern PATTERN_FLOAT = Pattern.compile("(\\+|-)?[0-9]+(\\.[0-9]+)?");
    public static final Pattern PATTERN_POSITIVE_NUMBER_AND_1000_UNITS = Pattern.compile("(\\+?0)|(\\+?[1-9][0-9]*000)");

    private final String content;

    Constant(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public Integer getContentToInteger() {
        return Converter.stringToInteger(content);
    }
    public Long getContentToLong() {
        return Converter.stringToLong(content);
    }

    public Float getContentToFloat() {
        return Converter.stringToFloat(content);
    }
}
