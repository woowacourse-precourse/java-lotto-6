package lotto;

import constant.GameValues;
import error.ErrorMessage;
import util.InputValidator;

public class LottoValidator {

    //돈 관련
    public void validateMoneyValue(int money) {
        //최소, 최대 금액
        if (!InputValidator.isValidRangeNum(money, GameValues.MIN_MONEY.getValue(), GameValues.MAX_MONEY.getValue())) {
            ErrorMessage.INVALID_MONEY_RANGE.errorHandle();
        }
        //돈 단위
        if (!InputValidator.isDivisible(money, GameValues.MONEY_UNIT.getValue())) {
            ErrorMessage.INVALID_MONEY_UNIT.errorHandle();
        }
    }


    //lotto 범위 확인
    public void validLottoNumRange(int number) {
        if (!InputValidator.isValidRangeNum(number, GameValues.MIN_LOTTO_NUM.getValue(),
                GameValues.MAX_LOTTO_NUM.getValue())) {
            ErrorMessage.INVALID_LOTTO_NUM_RANGE.errorHandle();
        }
    }


    public void validateBonusNumber(int bonusNumber, Lotto winningLotto) {

        validLottoNumRange(bonusNumber);

        if (winningLotto.isContain(bonusNumber)) {
            ErrorMessage.DUPLICATE_LOTTO_NUM.errorHandle();
        }

    }


}
