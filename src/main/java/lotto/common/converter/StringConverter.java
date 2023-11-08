package lotto.common.converter;

import java.util.Arrays;
import java.util.List;

public class StringConverter {

    public static int toInt(String value) {
        return parseInt(value);
    }

    public static List<Integer> toIntListWithSplit(String value, String delimiter) {
        return Arrays.stream(value.split(delimiter))
            .map(StringConverter::parseInt)
            .toList();
    }

    private static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 값만 입력하실 수 있습니다.");
        }
    }
}
