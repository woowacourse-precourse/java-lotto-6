package domain;

import exception.outOfLottoNumberRangeException;

public record LottoNumber(int lottoNumberValue) {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    public LottoNumber {
        if (isNotInLottoNumberRange(lottoNumberValue)) {
            throw new outOfLottoNumberRangeException(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

    private static boolean isNotInLottoNumberRange(int lottoNumberValue) {
        return lottoNumberValue < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < lottoNumberValue;
    }
}
