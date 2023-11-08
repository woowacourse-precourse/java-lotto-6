package lotto.util;

import java.util.List;
import lotto.constants.ErrorMessages;

public class Converter {

    public static int stringToInt(String inputNumber) {
        try {
            return Integer.parseInt(inputNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessages.NON_NUMERIC_INPUT_MESSAGE);
        }
    }

    public static List<Integer> stringListToIntegers(List<String> inputNumbers) {
        return inputNumbers.stream()
                .map(Converter::stringToInt)
                .toList();
    }

}
