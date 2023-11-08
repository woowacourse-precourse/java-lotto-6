package lotto.domain;

import static lotto.consts.ErrorMessage.BONUS_WRONG_RANGE_ERROR_MESSAGE;
import static lotto.consts.ErrorMessage.throwException;
import static lotto.consts.LottoConstance.MAX_NUMBER_LOTTO_RANGE;
import static lotto.consts.LottoConstance.MIN_NUMBER_LOTTO_RANGE;

public class Bonus {

    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    public int get() {
        return number;
    }

    private void validate(int number) {
        if (!isBetween1to45(number)) {
            throwException(BONUS_WRONG_RANGE_ERROR_MESSAGE.get());
        }
    }

    private boolean isBetween1to45(int number) {
        return number >= MIN_NUMBER_LOTTO_RANGE.get() && number <= MAX_NUMBER_LOTTO_RANGE.get();
    }

}
