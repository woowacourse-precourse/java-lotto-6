package lotto.domain;

import lotto.config.GameConfig;
import lotto.exception.LottoGameException;
import lotto.exception.LottoNumberException;

public record LottoNumber(int value) {

    public LottoNumber {
        validateLottoNumber(value);
    }

    private static void validateLottoNumber(int number) {
        if (number < GameConfig.LOTTO_MIN_NUMBER || number > GameConfig.LOTTO_MAX_NUMBER) {
            throw new LottoGameException(LottoNumberException.INVALID_RANGE);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
