package lotto.input.validator.impl;

import java.util.List;
import lotto.config.LottoConfig;
import lotto.exception.ExceptionStatus;
import lotto.input.validator.Validator;

public class InputValidator implements Validator {
    @Override
    public void validate(Integer number) throws IllegalArgumentException {
        if (LottoConfig.START_LOTTO_NUM.getNum() > number || number > LottoConfig.END_LOTTO_NUM.getNum()) {
            throw new IllegalArgumentException(ExceptionStatus.INPUT_OUT_OF_RANGE.getMessage());
        }
    }

    @Override
    public void validate(List<Integer> numbers) throws IllegalArgumentException {
        for (Integer number :numbers) {
            validate(number);
        }
    }
}
