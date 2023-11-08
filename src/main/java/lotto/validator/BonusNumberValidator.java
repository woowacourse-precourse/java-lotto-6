package lotto.validator;

import java.util.List;

import static lotto.constants.ExceptionMessage.*;
import static lotto.constants.LottoSetting.*;

public class BonusNumberValidator implements Validator {
    private List<Integer> winningNumbers;

    public BonusNumberValidator(List<Integer> winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    @Override
    public void validate(String input) {
        int bonusNumber = parseNumber(input);
        validateBonusNumberRange(bonusNumber);
        validateBonusNumberUniqueness(bonusNumber);
    }

    private void validateBonusNumberRange(int number) {
        if (number < MIN_LOTTO_NUMBER.value() || number > MAX_LOTTO_NUMBER.value()) {
            throw new IllegalArgumentException(BONUS_NUMBER_RANGE_ERROR.message());
        }
    }

    private void validateBonusNumberUniqueness(int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATES_WINNING_ERROR.message());
        }
    }

    private int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr.trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR.message());
        }
    }
}