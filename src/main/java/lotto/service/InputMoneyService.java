package lotto.service;

import lotto.util.Validator;

public class InputMoneyService {


    public void getRightMoneyProcess(Validator validator, String money) {
        try{
            validator.validateInputMoneyIsNumber(money);
            validator.validateNumberUnitIsThousand(Long.parseLong(money));
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }
}
