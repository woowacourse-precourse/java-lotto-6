package lotto.util;

import static lotto.config.GameTextConfig.LOTTO_NUMBER_SEPARATOR;
import static lotto.exception.ErrorMessage.VALIDATE_INPUT_NUMBER;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Parser {
    private Parser() {
    }

    public static List<String> splitBySeparator(String input) {
        return Arrays.asList(input.split(LOTTO_NUMBER_SEPARATOR.getText()));
    }

    public static int parseInt(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(VALIDATE_INPUT_NUMBER.getMessage());
        }
    }

    public static List<Integer> sortList(List<Integer> numbers) {
        numbers.sort(null);
        return numbers;
    }
}
