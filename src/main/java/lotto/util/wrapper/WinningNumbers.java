package lotto.model;


import static lotto.util.validators.WinningNumbersValidator.validateWinningNumber;

import java.util.Arrays;
import java.util.List;


public class WinningNumbers {
    private static final String SPLIT_REGEX = ",";

    private final List<String> value;

    public WinningNumbers(String value) {
        validateWinningNumber(value);
        this.value = parseStringToList(value);
    }

    private List<String> parseStringToList(String value) {
        return Arrays.asList(value.split(SPLIT_REGEX));
    }
}
