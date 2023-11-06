package lotto.validator;

import static lotto.model.constans.LottoSetting.*;
import static lotto.validator.constants.ExceptionMessage.*;
import static lotto.validator.constants.Pattern.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbersValidator implements Validator {
    public void validate(String winningNumbers) {
        isBlank(winningNumbers);
        isNotValidWinningNumbersPattern(winningNumbers);
        List<Integer> splitWinningNumbers = splitWinningNumbers(winningNumbers);
        isInvalidSizeWinningNumbers(splitWinningNumbers);
        containsInvalidRangeNumberInWinningNumbers(splitWinningNumbers);
        hasDuplicatesInWinningNumbers(splitWinningNumbers);
    }

    private void isNotValidWinningNumbersPattern(String winningNumbers) {
        if (!winningNumbers.matches(WINNING_NUMBERS.pattern())) {
            throw new IllegalArgumentException(WINNING_NUMBERS_PATTERN_ERROR.message());
        }
    }

    private List<Integer> splitWinningNumbers(String winningNumbers) {
        return Arrays.stream(winningNumbers.split(NUMBER_SEPARATOR.pattern()))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void isInvalidSizeWinningNumbers(List<Integer> winningNumbers) {
        if(winningNumbers.size() != WINNING_NUMBER_SIZE.value()) {
            throw new IllegalArgumentException(WINNING_NUMBERS_SIZE_ERROR.message());
        }
    }

    private void containsInvalidRangeNumberInWinningNumbers(List<Integer> winningNumbers) {
        for (int winningNumber : winningNumbers) {
            if (winningNumber < MIN_WINNING_NUMBER.value() || MAX_WINNING_NUMBER.value() < winningNumber) {
                throw new IllegalArgumentException(WINNING_NUMBERS_RANGE_ERROR.message());
            }
        }
    }

    private void hasDuplicatesInWinningNumbers(List<Integer> winningNumbers) {
        if (isDuplicate(winningNumbers)) {
            throw new IllegalArgumentException(WINNING_NUMBERS_DUPLICATE_ERROR.message());
        }
    }

    private boolean isDuplicate(List<Integer> winningNumbers) {
        return winningNumbers.stream()
                .distinct()
                .count() < winningNumbers.size();
    }
}
