package lotto.domain;

import lotto.ui.InputView;

public class UserInput {
    private String cost;
    public int setAmount() {
        this.cost = InputView.readCost();
        Validator validator = new Validator();
        return validator.validateCost(this.cost);
    }


}
