package lotto.validation;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberUtil;
import lotto.domain.Lotto;

import java.util.List;

public class BonusNumberValidation {
    NumericInputValidation numericInputValidation = new NumericInputValidation();

    public int validateBonusNumber(String input) {
        numericInputValidation.validateInputIsNumeric(input);
        validateCheckRangeOfBonusNumberInput(input);
        int bonusNumber = Integer.parseInt(input);
        validateBonusNumberIsPositive(bonusNumber);
        validateBonusNumberOutOfRange(bonusNumber);

        return bonusNumber;
    }

    public void validateCheckRangeOfBonusNumberInput(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException(ErrorMessage
                    .BONUS_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateBonusNumberIsPositive(int bonusNumber) {
        if (bonusNumber < NumberUtil.MIN_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage
                    .POSITIVE_BONUS_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }

    public void validateBonusNumberOutOfRange(int bonusNumber) {
        if (bonusNumber < NumberUtil.START_NUMBER.getNumber() ||
                bonusNumber > NumberUtil.END_NUMBER.getNumber()) {
            throw new IllegalArgumentException(ErrorMessage
                    .BONUS_NUMBER_OUT_OF_RANGE_MESSAGE
                    .getMessage());
        }
    }

    public void validateDuplicateBonusNumber(Lotto lotto, int bonusNumber) {
        List<Integer> winnerNumbers = lotto.getLottoNumbers();
        if (winnerNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage
                    .DUPLICATE_WINNING_NUMBER_CONSTRAINT_MESSAGE
                    .getMessage());
        }
    }
}
