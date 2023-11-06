package lotto.domain;

import static lotto.utils.ErrorMessage.IS_INVALID_LOTTO_NUMBER_RANGE;
import static lotto.utils.ErrorMessage.IS_INVALID_LOTTO_SIZE;

import java.util.List;

public class LottoNumber {
    protected static final int LOTTO_SIZE = 6;
    protected static final int NUMBER_MAX_SIZE = 45;
    protected static final int NUMBER_MIN_SIZE = 1;

    int LottoNumber;

    public LottoNumber(int lottoNumber) {
        isLottoNumberRangeValid(lottoNumber);
        LottoNumber = lottoNumber;
    }
    public LottoNumber() {
    }

    protected void isLottoNumberRangeValid(int number) {
        if (number > NUMBER_MAX_SIZE || number < NUMBER_MIN_SIZE) {
            throw new IllegalArgumentException(IS_INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    protected void isLottoSizeValid(List<Integer> numbers,int validSize) {
        if (numbers.size() != validSize) {
            throw new IllegalArgumentException(IS_INVALID_LOTTO_SIZE.getMessage());
        }
    }
}
