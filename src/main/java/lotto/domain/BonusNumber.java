package lotto.domain;

import lotto.util.ExceptionMessage;
import lotto.util.Util;
import lotto.util.enumerator.LottoNumberRange;
import lotto.util.enumerator.LottoRank;

public class BonusNumber {
    private final int number;

    public BonusNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) throws IllegalArgumentException {
        if (number < LottoNumberRange.MIN_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_MIN_RANGE.getMessage());
        }
        if (number > LottoNumberRange.MAX_LOTTO_NUMBER.getValue()) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_LOTTO_NUMBER_MAX_RANGE.getMessage());
        }
    }

    public LottoRank compareWithLottoNumber(Lotto lotto) {
        if (isMatchWithLottoNumbers(lotto)) {
            return LottoRank.SECOND;
        }
        return LottoRank.THIRD;
    }

    private boolean isMatchWithLottoNumbers(Lotto lotto) {
        int bonus = this.number;
        for (int number : lotto.getNumbers()) {
            if (Util.isEqual(number, bonus)) {
                return true;
            }
        }
        return false;
    }
}
