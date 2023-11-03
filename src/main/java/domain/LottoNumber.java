package domain;

import exception.OutOfLottoNumberRangeException;

public record LottoNumber(int lottoNumberValue) {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    public LottoNumber {
        if (isNotInLottoNumberRange(lottoNumberValue)) {
            throw new OutOfLottoNumberRangeException(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
        }
    }

    private static boolean isNotInLottoNumberRange(int lottoNumberValue) {
        return lottoNumberValue < MIN_LOTTO_NUMBER || MAX_LOTTO_NUMBER < lottoNumberValue;
    }
}
