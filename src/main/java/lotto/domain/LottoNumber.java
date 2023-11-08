package lotto.domain;

import lotto.exception.OutOfLottoNumberRangeException;

public record LottoNumber(int lottoNumberValue) implements Comparable<LottoNumber> {
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

    @Override
    public int compareTo(LottoNumber o) {
        return Integer.compare(this.lottoNumberValue, o.lottoNumberValue);
    }
}
