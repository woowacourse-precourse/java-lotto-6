package lotto.domain;

import lotto.config.Constant;
import lotto.util.validator.WinningNumbersValidator;

import java.util.Arrays;
import java.util.List;

public class WinningNumbers {
    private final List<Integer> winningNumbers;

    WinningNumbers(String numbers) {
        new WinningNumbersValidator(numbers);
        this.winningNumbers = parseWinningNumbers(numbers);
    }

    private List<Integer> parseWinningNumbers(String numbers) {
        return Arrays.stream(numbers.split(Constant.NUMBER_DELIMITER))
                .mapToInt(Integer::valueOf)
                .boxed()
                .toList();
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }
}
