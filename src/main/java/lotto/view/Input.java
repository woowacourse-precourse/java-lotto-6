package lotto.view;

import lotto.domain.InputValidation;

public class Input {
    public static int readAmount(String input) {
        int amount = InputValidation.validateNumber(input);
        InputValidation.checkDivisible(amount);
        InputValidation.checkSufficient(amount);
        return amount;
    }
}
