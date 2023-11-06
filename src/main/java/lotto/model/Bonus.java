package lotto.model;

import lotto.enums.Constant;
import lotto.enums.ErrorMessage;

public class Bonus {
    private final Integer bonusNumber;

    public Bonus (Integer bonusNumber) {
        validateRange(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private void validateRange(Integer number) {
        if (number < Constant.START_RANGE_OF_NUMBER.getValue()
                || Constant.END_RANGE_OF_NUMBER.getValue() < number) {
            throw new IllegalArgumentException(String.format(
                    ErrorMessage.LOTTO_NUMBERS_HAS_RANGE.getMessage(),
                    Constant.START_RANGE_OF_NUMBER.getValue(),
                    Constant.END_RANGE_OF_NUMBER.getValue()
            ));
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
