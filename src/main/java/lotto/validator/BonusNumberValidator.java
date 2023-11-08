package lotto.validator;

import lotto.domain.Lotto;

import static lotto.message.ErrorMessage.*;

public class BonusNumberValidator {
    private static final int MIN_BONUS_NUMBER = 1;
    private static final int MAX_BONUS_NUMBER = 45;

    public void validate(String input,Lotto lotto) {
        isBonusNumberNumeric(input);
        int bonusNumber = Integer.parseInt(input);
        isBonusNumberInRange(bonusNumber);
        isBonusDuplicateByLottoNumber(bonusNumber,lotto);
    }

    private void isBonusNumberInRange(int bonusNumber) {
        if (bonusNumber < MIN_BONUS_NUMBER || MAX_BONUS_NUMBER < bonusNumber) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_IN_RANGE_MESSAGE.getMessage());
        }
    }

    private void isBonusNumberNumeric(String bonusNumber) {
        try {
            Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_NOT_NUMERIC_MESSAGE.getMessage());
        }
    }

    private void isBonusDuplicateByLottoNumber(int bonusNumber, Lotto lotto) {
        if (lotto.isNumberExist(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_IS_DUPLICATED_BY_LOTTO_NUMBER.getMessage());
        }
    }
}
