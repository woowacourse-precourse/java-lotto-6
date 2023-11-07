package lotto.controller;

import lotto.util.Validator;

public class InputController {
    private void validateInput(String input) {
        Validator.validateInputNotEmpty(input);
        Validator.validateIsParsableToInt(input);
    }
}
