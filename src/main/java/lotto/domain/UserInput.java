package lotto.domain;

import lotto.ui.InputView;

public class UserInput {
    public int setAmount() {
        String cost;
        cost = InputView.readCost();
        Validator validator = new Validator();
        return validator.validateCost(cost);
    }
}
