package lotto.service;

import java.util.regex.Pattern;
import lotto.exception.InputDataNotNumberException;

public class InputValidator {

    private static final String NUMBER = "^[0-9]*$";

    public void validateInputDataIsNumber(String inputData) {
        if (!Pattern.matches(NUMBER, inputData)) {
            throw new InputDataNotNumberException();
        }
    }
}
