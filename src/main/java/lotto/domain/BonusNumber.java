package lotto.domain;

import lotto.util.message.ExceptionMessage;

import java.util.List;

import static lotto.domain.LottoInfo.MAX_NUMBER;
import static lotto.domain.LottoInfo.MIN_NUMBER;

public class BonusNumber {

    private final Integer number;

    public static BonusNumber of(Integer number) {
        return new BonusNumber(number);
    }

    private BonusNumber(Integer number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(Integer number) {
        if (isNotInRange(number)) {
            throw new IllegalArgumentException(ExceptionMessage.CHECK_RANGE_BONUS_NUM.getMessage());
        }
    }

    private boolean isNotInRange(Integer number) {
        return number < MIN_NUMBER.getNumberInfo() || number > MAX_NUMBER.getNumberInfo();
    }

    public boolean containsIn(List<Integer> numbers) {
        return numbers.contains(number);
    }
}
