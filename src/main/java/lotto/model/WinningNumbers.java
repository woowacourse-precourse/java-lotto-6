package lotto.util.wrapper;


import static lotto.util.validators.WinningBonusNumbersValidator.validateWinningNumber;

import java.util.Arrays;
import java.util.List;


public class WinningNumbers {
    private static final String SPLIT_REGEX = ",";

    private final List<Integer> value;

    public WinningNumbers(String value) {
        validateWinningNumber(value);
        this.value = Arrays.stream(value.split(SPLIT_REGEX))
                .map(Integer::valueOf)
                .sorted()
                .toList();
    }

    public List<Integer> getValue() {
        return this.value;
    }
}
