package lotto.model;

import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstant;

public class Bonus {

    private final int number;

    public Bonus(int number, Lotto lotto) {
        validate(number, lotto);
        this.number = number;
    }

    private void validate(int number, Lotto lotto) {
        validateRange(number);
        validateDuplicateWithLotto(number, lotto);
    }

    private void validateRange(int number) {
        if (number < LottoConstant.MIN_LOTTO_NUMBER.get() ||
                number > LottoConstant.MAX_LOTTO_NUMBER.get()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.get());
        }
    }

    private void validateDuplicateWithLotto(int number, Lotto lotto) {
        if (lotto.contains(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_DUPLICATE_WITH_LOTTO.get());
        }
    }

    public boolean isSameWith(int compareNumber) {
        return number == compareNumber;
    }

    public int number() {
        return number;
    }
}