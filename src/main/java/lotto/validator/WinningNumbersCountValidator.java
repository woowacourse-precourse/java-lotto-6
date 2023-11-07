package lotto.validator;

import lotto.domain.constants.ExceptionMessage;
import lotto.domain.constants.LottoSetting;

import java.util.List;

public class WinningNumbersCountValidator implements Validator<List<Integer>> {
    @Override
    public void validate(List<Integer> inputNumbers) {
        if (inputNumbers.size() != LottoSetting.LOTTO_WINNING_NUMBERS_COUNT.getNumber()) {
            throwException(ExceptionMessage.WINNING_NUMBERS_COUNT_OUT_OF_RANGE.getMessage());
        }
    }
}
