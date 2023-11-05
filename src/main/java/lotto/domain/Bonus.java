package lotto.domain;

import lotto.constant.LottoConstant;
import lotto.exception.ExceptionType;
import lotto.exception.InputException;

public class Bonus {
    private final int bouns;

    public Bonus(int bouns) {
        validate(bouns);
        this.bouns = bouns;
    }

    private void validate(int bouns) {
        if(islottoRange(bouns)){
            throw new InputException(ExceptionType.ERROR_LOTTO_RANGE);
        }
    }

    private boolean islottoRange(int bouns) {
        return LottoConstant.LOTTO_START_NUMBER > bouns || LottoConstant.LOTTO_END_NUMBER < bouns;
    }

}
