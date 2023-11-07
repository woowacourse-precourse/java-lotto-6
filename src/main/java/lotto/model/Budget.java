package lotto.model;

import static lotto.utils.LottoConstant.LOTTO_PRICE;

import lotto.validator.BudgetValidator;

public class Budget {
    private final int budget;

    public Budget(int budget) {
        validatebudget(budget);
        this.budget = budget;
    }

    private void validatebudget(int budget) {
        BudgetValidator.validateBudgetRange(budget);
        BudgetValidator.validateBudgetDivision(budget);
    }

    public int getValue() {
        return budget;
    }

    public int getLottoQuantity() {
        return budget / LOTTO_PRICE.getValue();
    }
}
