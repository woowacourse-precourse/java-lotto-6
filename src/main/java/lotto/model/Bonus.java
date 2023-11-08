package lotto.model;

import lotto.enums.Constant;
import lotto.enums.ErrorMessage;

public class Bonus {
    private final Integer bonusNumber;

    public Bonus(Integer bonusNumber, Lotto lotto) {
        validateRange(bonusNumber);
        validateDuplicate(bonusNumber, lotto);

        this.bonusNumber = bonusNumber;
    }

    private void validateRange(Integer number) {
        if (number < Constant.START_RANGE_OF_NUMBER.getContentToInteger()
                || Constant.END_RANGE_OF_NUMBER.getContentToInteger() < number) {
            throw new IllegalArgumentException(String.format(
                    ErrorMessage.LOTTO_NUMBERS_HAS_RANGE.getMessage(),
                    Constant.START_RANGE_OF_NUMBER.getContentToInteger(),
                    Constant.END_RANGE_OF_NUMBER.getContentToInteger()
            ));
        }
    }

    private void validateDuplicate(Integer number, Lotto lotto) {
        if (lotto.isMatch(number)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBERS_HAS_NO_DUPLICATE.getMessage());
        }
    }

    public Integer countMatchesBonus(Lotto targetLotto) {
        Integer count = 0;

        if (targetLotto.isMatch(bonusNumber)) {
            ++count;
        }

        return count;
    }
}
