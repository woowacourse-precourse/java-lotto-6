package lotto.utils;

import static lotto.enums.Constant.PATTERN_FLOAT;
import static lotto.enums.Constant.PATTERN_NUMBER;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import lotto.enums.Constant;
import lotto.enums.ErrorMessage;

public class Converter {
    public static Integer stringToInteger(String text) {
        text = text.strip();
        validateNumberPattern(text);

        return Integer.parseInt(text);
    }

    public static List<Integer> stringToIntegerList(String text) {
        List<Integer> converted = new ArrayList<>();

        for (String item : text.split(Constant.DELIMITER.getContent())) {
            converted.add(Converter.stringToInteger(item));
        }

        return converted;
    }

    public static Float stringToFloat(String text) {
        validateFloatPattern(text);

        return Float.parseFloat(text);
    }

    public static Long stringToLong(String text) {
        validateNumberPattern(text);

        return Long.parseLong(text);
    }

    public static Float integerToFloat(Integer number) {
        return number.floatValue();
    }

    public static Float longToFloat(Long number) {
        return number.floatValue();
    }

    private static void validateNumberPattern(String text) {
        Matcher numberPattern = PATTERN_NUMBER.matcher(text);

        if (numberPattern.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.STRING_CANNOT_CONVERT_TO_INTEGER.getMessage());
        }
    }

    private static void validateFloatPattern(String text) {
        Matcher floatPattern = PATTERN_FLOAT.matcher(text);

        if (floatPattern.matches() == false) {
            throw new IllegalArgumentException(ErrorMessage.STRING_CANNOT_CONVERT_TO_FLOAT.getMessage());
        }
    }
}
