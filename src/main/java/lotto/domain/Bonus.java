package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;

public class Bonus {
    private final int number;

    public Bonus(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if(islottoRange(number)){
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }
    }

    private boolean islottoRange(int number) {
        return LottoConstant.LOTTO_START_NUMBER > number || LottoConstant.LOTTO_END_NUMBER < number;
    }

    public int getNumber() {
        return this.number;
    }
}
