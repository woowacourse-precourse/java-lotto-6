package lotto.view.validator;

import lotto.view.exception.LottoInputException;
import lotto.view.message.LottoInputExceptionMessage;

public class BonusNumberValidator {
    public void validate(String userInput) {
        isNotEmpty(userInput);
    }

    private void isNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw LottoInputException.of(LottoInputExceptionMessage.INPUT_IS_EMPTY);
        }
    }
}