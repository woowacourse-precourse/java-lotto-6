package lotto.domain;

import static lotto.utils.ErrorMessage.IS_INVALID_LOTTO_NUMBER_RANGE;
import static lotto.utils.LottoConstants.NUMBER_MAX_SIZE;
import static lotto.utils.LottoConstants.NUMBER_MIN_SIZE;

public class LottoSingleNumber {
    int lottoSingleNumber;

    public LottoSingleNumber(int number) {
        isLottoNumberRangeValid(number);
        lottoSingleNumber = number;
    }

    protected void isLottoNumberRangeValid(int number) {
        if (number > NUMBER_MAX_SIZE.getValue() || number < NUMBER_MIN_SIZE.getValue()) {
            throw new IllegalArgumentException(IS_INVALID_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    public int getNumber() {
        return lottoSingleNumber;
    }
}
