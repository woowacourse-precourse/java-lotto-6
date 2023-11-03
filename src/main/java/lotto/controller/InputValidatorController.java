package lotto.controller;

public class InputValidatorController {

    public void blank(String purchaseAmount) throws IllegalArgumentException  {
        if (purchaseAmount.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
