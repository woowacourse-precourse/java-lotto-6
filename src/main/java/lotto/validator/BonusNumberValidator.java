package lotto.validator;

import lotto.exception.ExceptionMessage;
import lotto.model.Lotto;

public class BonusNumberValidator extends Validator {
    @Override
    public void validate(String input) {
        input = removeSpace(input);
        validateOnlyNumber(input);
        validateLottoRange(Integer.parseInt(input));
    }

    public void validateDuplicated(int bonusNumber, Lotto lotto) {
        if (lotto.isContain(bonusNumber)) {
            throw new IllegalArgumentException(ExceptionMessage.DUPLICATE_EXCEPTION.getMessage());
        }
    }
}
