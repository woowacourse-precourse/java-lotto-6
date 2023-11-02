package lotto.controller;

import lotto.valid.MoneyValid;
import lotto.view.InputView;

public class InputController {

    public static int inputBuyingMoney() {
        String input = InputView.inputBuyingMoney();
        try {
            return MoneyValid.validMoney(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBuyingMoney();
        }
    }
}
