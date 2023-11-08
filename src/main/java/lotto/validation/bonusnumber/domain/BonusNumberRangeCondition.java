package lotto.validation.bonusnumber.domain;

import lotto.validation.ValidationCondition;

public class BonusNumberRangeCondition extends ValidationCondition {

    private int lottoMinValue;
    private int lottoMaxValue;
    private static final String EXCEPTION_MSG = "입력 값의 범위를 확인해주세요.";

    public BonusNumberRangeCondition(int lottoMinValue, int lottoMaxValue) {
        this.lottoMinValue = lottoMinValue;
        this.lottoMaxValue = lottoMaxValue;
    }

    @Override
    protected void validateCondition(Object obj) {
        int bonusNumber = (Integer) obj;

        if (!isLottoNumInRange(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MSG + EXCEPTION_MSG);
        }
    }

    @Override
    protected boolean isObjectOf(Object obj) {
        return obj instanceof Integer;
    }

    private boolean isLottoNumInRange(int bonusNumber) {
        return lottoMinValue <= bonusNumber && lottoMaxValue >= bonusNumber;
    }

}
