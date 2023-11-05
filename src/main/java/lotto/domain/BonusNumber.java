package lotto.domain;

import lotto.util.ExceptionMessage;

import static lotto.domain.LottoInfo.MAX_NUMBER;
import static lotto.domain.LottoInfo.MIN_NUMBER;

public class BonusNumber {

    private final Integer number;

    public static BonusNumber of(Integer number) {
        return new BonusNumber(number);
    }

    private BonusNumber(Integer number) {
        validateNumber(number);
        this.number = number;
    }

    private void validateNumber(Integer number) {
        if (isNotInRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_RANGE_BONUS_NUM.getMessage());
        }
    }

    private boolean isNotInRange(Integer number) {
        return number < MIN_NUMBER.getNumberInfo() || number > MAX_NUMBER.getNumberInfo();
    }
}
