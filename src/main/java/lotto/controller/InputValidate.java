package lotto.controller;

import lotto.model.domain.exception.InputException;

public class InputValidate {

    private InputValidate() {

    }

    public static void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            InputException.inputNumberException();
        }
    }
}
