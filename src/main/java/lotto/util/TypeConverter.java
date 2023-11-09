package lotto.util;

import java.util.List;
import java.util.stream.Stream;

public class TypeConverter {
    private static final String WRONG_NUMBER_INPUT_MSG = "숫자만 입력해주세요. 복수 입력 시 쉼표(,)로 구분해주세요.";
    private static final String DELIMITER = ",";

    public static int toInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(WRONG_NUMBER_INPUT_MSG);
        }
    }

    public static List<Integer> toList(String input) {
        return Stream.of(input.split(DELIMITER))
                .map(TypeConverter::toInt)
                .toList();
    }
}
