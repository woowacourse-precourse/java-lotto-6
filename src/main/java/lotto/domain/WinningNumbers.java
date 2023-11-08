package lotto.domain;

import java.util.List;
import java.util.regex.Pattern;

public class WinningNumbers {
    private final List<Integer> numbers;
    private static final String CONSECUTIVE_COMMA_ERROR_MESSAGE = "[ERROR] 입력에 쉼표가 연속해서 있습니다.";
    private static final String SPECIAL_CHARACTER_ERROR_MESSAGE = "[ERROR] 쉼표를 제외한 특수문자는 사용할 수 없습니다.";
    private static final Pattern WINNING_NUMBERS_REGEX = Pattern.compile("^(\\s*\\d+\\s*,\\s*)*\\d+\\s*$");
    public WinningNumbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateLotto(numbers);
        validateConsecutiveCommas(numbers);
        validateSpecialCharacters(numbers);
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

    private void validateSpecialCharacters(List<Integer> numbers) {
        String winningNumbersString = numbers.toString().replaceAll("\\s*,\\s*", ",");
        if (!WINNING_NUMBERS_REGEX.matcher(winningNumbersString).matches()) {
            throw new IllegalArgumentException(SPECIAL_CHARACTER_ERROR_MESSAGE);
        }
    }
}
