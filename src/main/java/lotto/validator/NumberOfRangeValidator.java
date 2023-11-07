package lotto.validator;

import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoSetting;

public class NumberOfRangeValidator implements Validator<Integer> {
    @Override
    public void validate(Integer number) {
        if (number < LottoSetting.LOTTO_NUMBER_RANGE_START.getNumber() ||
                number > LottoSetting.LOTTO_NUMBER_RANGE_END.getNumber()) {
            throwException(ExceptionMessage.NUMBER_OUT_OF_RANGE.getMessage());
        }
    }
}
