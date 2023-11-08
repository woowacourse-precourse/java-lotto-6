package lotto.domain;

import java.util.List;

public class WinningNumbers {
    private final List<Integer> numbers;
    private static final String CONSECUTIVE_COMMA_ERROR_MESSAGE = "[ERROR] 입력에 쉼표가 연속해서 있습니다.";

    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLotto(numbers);
        validateConsecutiveCommas(numbers);
    }

    private void validateLotto(List<Integer> numbers) {
        Lotto lotto = new Lotto(numbers);
        lotto.validate(numbers);
    }

    private void validateConsecutiveCommas(List<Integer> numbers) {
        String winningNumbersString = numbers.toString().replaceAll("\\s*,\\s*", ",");
        if (winningNumbersString.contains(",,") || winningNumbersString.startsWith(",") || winningNumbersString.endsWith(",")) {
            throw new IllegalArgumentException(CONSECUTIVE_COMMA_ERROR_MESSAGE);
        }
    }
}
