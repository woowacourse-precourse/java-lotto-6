package lotto.Domain;

import lotto.Util.Validator;

public class Budget {

    public static final int LOTTO_PRICE = 1000;
    private int budgetAmount;

    public Budget(String budget) throws IllegalArgumentException{
        Validator.validateBudget(budget);
        budgetAmount = Integer.parseInt(budget);
    }

    public int calculateLottoCount() {
        return budgetAmount / LOTTO_PRICE;
    }
}
