package lotto.utils;

import lotto.view.Input;

import static lotto.utils.ExceptionMessage.NON_DIVISIBLE_BY_1000;
import static lotto.utils.ExceptionMessage.NOT_NUMBER;

public class PurchaseAmountException {
    Input input = new Input();

    public void totalException(String input) {
        notNumeric(input);
        notDivisible(input);
    }

    public void notNumeric(String input) {
        try {
            Integer.parseInt(input);
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER.getMessage());
        }
        this.input.inputPurchaseAmount();
    }

    public void notDivisible(String input) {
        int numberInput = Integer.parseInt(input);
        if(numberInput % 1000 != 0) {
            throw new IllegalArgumentException(NON_DIVISIBLE_BY_1000.getMessage());
        }
        this.input.inputPurchaseAmount();
    }
}
