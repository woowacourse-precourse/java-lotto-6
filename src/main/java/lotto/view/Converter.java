package lotto.view;

import static lotto.option.Error.NOT_NUMBER;

import java.util.Arrays;
import java.util.List;

public class Converter {
    private Converter() {
    }

    public static int stringToInt(String number) {
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
    }

    public static List<Integer> stringToListInteger(String number) {
        List<String> stringNumbers = Arrays.stream(number.split(",")).toList();
        try {
            return stringNumbers.stream()
                    .map(Integer::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }

    }
}
