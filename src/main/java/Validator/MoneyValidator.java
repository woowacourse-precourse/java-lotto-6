package Validator;

import static Constant.ErrorMessage.ERROR_MSG_INPUT_COST_OF_LOTTO_UNIT;
import static Constant.LottoSettingValue.COST_OF_LOTTO;

public class MoneyValidator {

    public static void isDividedInto1000(Integer money) throws IllegalArgumentException{
        if(money % COST_OF_LOTTO != 0){
            throw new IllegalArgumentException(ERROR_MSG_INPUT_COST_OF_LOTTO_UNIT);
        }
    }

}
