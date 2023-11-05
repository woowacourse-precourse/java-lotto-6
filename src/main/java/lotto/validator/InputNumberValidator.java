package lotto.validator;

import lotto.domain.constants.ExceptionMessage;

public class InputNumberValidator implements Validator<String> {

    @Override
    public void validate(String playerInput) {
        if (!playerInput.matches(ExceptionMessage.ONLY_NUMBER_REGEX.getMessage())) {
            throwException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
    }
}
