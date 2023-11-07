package Validator;

import static Constant.LottoSettingValue.COST_OF_LOTTO;

public class MoneyValidator {

    public static final String ERROR_MSG_INPUT_COST_OF_LOTTO_UNIT = "[ERROR] 1,000원 단위로 금액을 입력해 주세요.";

    public static void isDividedInto1000(Integer money) throws IllegalArgumentException{
        if(money % COST_OF_LOTTO != 0){
            throw new IllegalArgumentException(ERROR_MSG_INPUT_COST_OF_LOTTO_UNIT);
        }
    }

}
