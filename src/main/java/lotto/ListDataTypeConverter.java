package lotto;

import java.util.List;
import java.util.stream.Collectors;

public class ListDataTypeConverter {
    private final static String ERROR_STRING_TO_INTEGER = "변환 하려는 문자열이 숫자로만 이루어져 있지 않습니다.";

    public static List<String> integerToString(List<Integer> elements) {
        return elements.stream().map(element -> Integer.toString(element)).collect(Collectors.toList());
    }

    public static List<Integer> stringToInteger(List<String> elements) {
        try {
            return elements.stream().map(Integer::parseInt).collect(Collectors.toList());
        }catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_STRING_TO_INTEGER);
        }
    }
}
