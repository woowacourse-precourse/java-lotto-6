package lotto.util;

import java.util.List;

public class Converter {
    private static final String NON_NUMERIC_INPUT_MESSAGE = "[ERROR] 숫자를 입력해주세요.";

    public static int stringToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NON_NUMERIC_INPUT_MESSAGE);
        }
    }

    public static List<Integer> stringListToIntegers(List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Converter::stringToInt)
                .toList();
    }

}
