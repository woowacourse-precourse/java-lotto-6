package lotto.view;

import java.util.Arrays;
import java.util.List;

class InputViewConvertor {

    public static List<Integer> parseInts(String value) {
        try {
            String[] values = value.split(InputViewConfig.NUMBERS_DELIMITER.getValue());
            return Arrays.stream(values)
                    .map(InputViewConvertor::parseInt)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessages.NOT_A_NUMBER.getMessage());
        }
    }

    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(InputExceptionMessages.NOT_A_NUMBER.getMessage());
        }
    }

}
