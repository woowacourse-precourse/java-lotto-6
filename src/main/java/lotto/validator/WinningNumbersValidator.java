package lotto.validator;

import static lotto.model.constans.LottoSetting.*;
import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator {
    public void validate(String winningNumbers) {
        isBlank(winningNumbers);
        isNotValidWinningNumbersPattern(winningNumbers);
        List<Integer> splitWinningNumbers = splitWinningNumbers(winningNumbers);
        containsInvalidRangeNumberInWinningNumbers(splitWinningNumbers);
        hasDuplicatesInWinningNumbers(splitWinningNumbers);
    }

    private void isBlank(String winningNumbers) {
        if (winningNumbers == null || winningNumbers.isBlank()) {
            throw new IllegalArgumentException(BLANK_ERROR.message());
        }
    }

    private void isNotValidWinningNumbersPattern(String winningNumbers) {
        if (!winningNumbers.matches(WINNING_NUMBERS.pattern())) {
            throw new IllegalArgumentException(WINNING_NUMBERS_PATTERN_ERROR.message());
        }
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(NUMBER_SPLITOR.pattern()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void containsInvalidRangeNumberInWinningNumbers(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MIN_LOTTO_NUMBER.value() || MAX_LOTTO_NUMBER.value() < winningNumber) {
                throw new IllegalArgumentException(LOTTO_ERROR.message());
            }
        }
    }

    private void hasDuplicatesInWinningNumbers(List<Integer> winningNumbers) {
        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(LOTTO_ERROR.message());
        }
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .count() < winningNumbers.size();
    }
}
