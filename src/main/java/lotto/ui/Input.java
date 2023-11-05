package lotto.ui;

import lotto.domain.InputValidation;

public class Input {
    public static int readAmount(String input) {
        int amount = InputValidation.validateNumber(input);
        InputValidation.checkSufficient(amount);
        InputValidation.checkDivisible(amount);
        return amount;
    }
}
