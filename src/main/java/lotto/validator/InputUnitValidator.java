package lotto.validator;

import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoSetting;

public class InputUnitValidator implements Validator<Integer> {
    @Override
    public void validate(Integer inputMoney) {
        if (inputMoney % LottoSetting.LOTTO_PRICE.getNumber() != 0) {
            throwException(ExceptionMessage.INPUT_MONEY_NOT_PRICE_UNIT.getMessage());
        }
    }
}
