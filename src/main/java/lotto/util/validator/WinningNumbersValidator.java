package lotto.util.validator;

import lotto.config.Constant;
import lotto.config.ErrorMessage;
import lotto.config.LottoConfig;
import lotto.util.Util;

import java.util.List;

public class WinningNumbersValidator extends InputValidator {

    public WinningNumbersValidator(String numbers) {
        super(numbers);
        validateInputFormat();

        List<String> winningNumbers = List.of(super.input.split(Constant.NUMBER_DELIMITER));
        validateDuplicateNumber(winningNumbers);
        winningNumbers.forEach(this::validateNumberInRange);
    }

    private void validateInputFormat() {
        if(!super.input.matches(Constant.PATTERN_NUMBERS)) {
            throw new IllegalArgumentException(ErrorMessage.CONTAIN_IMPROPER_LETTER.getMessage());
        }
    }

    private void validateDuplicateNumber(List<String> numbers) {
        if(numbers.size() != Util.distinctListSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER.getMessage());
        }
    }

    private void validateNumberInRange(String inputNumber) {
        final int number = Integer.parseInt(inputNumber);
        if(number < LottoConfig.LOTTO_NUMBER_MIN.getNumber() || number > LottoConfig.LOTTO_NUMBER_MAX.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage.OUT_RANGE_NUMBER.getMessage());
        }
    }
}