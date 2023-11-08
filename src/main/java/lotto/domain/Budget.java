package lotto.domain;

import lotto.util.Validator;

public class Budget {
    private int budget;

    public Budget(int budget) {
        validate(budget);
        this.budget = budget;
    }

    public int getBudget() {
        return budget;
    }

    public int getQuantity() {
        return this.budget / 1000;
    }

    private void validate(int budget) {
        Validator.checkBudget(budget);
    }

}
