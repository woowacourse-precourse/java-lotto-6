package lotto.Validator;

import static lotto.constant.Constant.DUPLICATE_ERROR;
import static lotto.constant.Constant.LOTTO_NUMBER_SIZE;
import static lotto.constant.Constant.NOT_NUMBER_ERROR;
import static lotto.constant.Constant.NUMBER_SCOPE_ERROR;
import static lotto.constant.Constant.WINNING_NUMBER_SIZE_ERROER;

import java.util.List;

public class WinningNumberInputValidate {
    public void valueSizeValidate(List<String> values) {
        if (values.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROER);
        }
    }

    public Integer isNumberValidate(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
        return number;
    }

    public void scopeValidate(Integer value) {
        if (value > 45 || value < 1) {
            throw new IllegalArgumentException(NUMBER_SCOPE_ERROR);
        }
    }

    public void isDuplicateValidate(Integer value, List<Integer> winningNumbers) {
        if (winningNumbers.contains(value)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
        winningNumbers.add(value);
    }
}
