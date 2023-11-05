package lotto.controller;

import lotto.model.Money;
import lotto.view.Input;

public class InputController {
    private InputController() {};

    public static Money getMoney() {
        try {
            return new Money(Input.inputMoneyGuide());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getMoney();
        }
    }
}
