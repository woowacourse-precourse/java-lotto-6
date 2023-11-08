package lotto.service;

import lotto.util.Validator;

public class InputMoneyService {


    public void getRightMoneyProcess(Validator validator, String money) {
        validator.validateInputMoneyIsNumber(money);
        long convertedMoney = Long.parseLong(money);
        validator.validateNumberNegativeOrZero(convertedMoney);
        validator.validateNumberUnitIsThousand(convertedMoney);
    }
}
