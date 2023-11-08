package lotto.util.validator;

import lotto.config.Constant;
import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.util.Util;

import java.util.List;

public class WinningNumbersValidator {
    private final String numbers;

    public WinningNumbersValidator(String numbers) {
        this.numbers = numbers;
        validateInputFormat();

        List<String> winningNumbers = List.of(numbers.split(Constant.NUMBER_DELIMITER));
        validateNumberCount(winningNumbers);
        validateDuplicateNumber(winningNumbers);
        winningNumbers.forEach(this::validateNumberInRange);
    }

    private void validateInputFormat() {
        if (!numbers.matches(Constant.PATTERN_NUMBERS)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private void validateNumberCount(List<String> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_NUMBER_COUNT.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_FORMAT.getMessage());
        }
    }

    private void validateDuplicateNumber(List<String> numbers) {
        if (numbers.size() != Util.distinctListSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberInRange(String inputNumber) {
        final int number = Integer.parseInt(inputNumber);
        if (number < LottoConfig.LOTTO_NUMBER_MIN.getNumber() || number > LottoConfig.LOTTO_NUMBER_MAX.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_NUMBER.getMessage());
        }
    }
}