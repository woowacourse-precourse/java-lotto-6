package lotto.validator;

import lotto.domain.constants.ExceptionMessage;

public class OnlyNumberValidator implements Validator<String> {
    @Override
    public void validate(String value) {
        if (!value.matches(ExceptionMessage.ONLY_NUMBER_REGEX.getMessage())) {
            throwException(ExceptionMessage.NOT_NUMBER.getMessage());
        }
    }
}
