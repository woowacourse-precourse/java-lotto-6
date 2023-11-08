package lotto.view;

import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.DUPLICATED_BONUS_NUMBER;
import static lotto.view.constant.ViewConstant.InputViewConstant.InputErrorMessage.NOT_EXIST_INPUT_ERROR;

import java.util.function.Supplier;

public class BonusNumberInputView implements LottoInputViewable, Supplier<Integer> {
    private final String winningNumber;

    public BonusNumberInputView(String winningNumber) {
        this.winningNumber = winningNumber;
    }

    @Override
    public Integer get() {
        return Integer.valueOf(receiveInput());
    }

    @Override
    public void validate(String input) {
        if (input.isBlank()) {
            throw new IllegalArgumentException(NOT_EXIST_INPUT_ERROR.getErrorMessage());
        }
        validateLottoNumber(input);
        if (winningNumber.contains(input)) {
            throw new IllegalArgumentException(DUPLICATED_BONUS_NUMBER.getErrorMessage());
        }
    }
}
