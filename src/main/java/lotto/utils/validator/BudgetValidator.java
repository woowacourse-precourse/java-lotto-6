package lotto.utils.validator;

import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

public class BudgetValidator implements Validator<Integer> {

    @Override
    public void validate(Integer budget) {
        validateBudgetIsPositive(budget);
        validateBudgetAmount(budget);
    }

    private void validateBudgetAmount(int budget) {
        if (budget % Constants.LOTTO_PRICE != Constants.ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BUDGET_AMOUNT.getMessage());
        }
    }

    private void validateBudgetIsPositive(int budget) {
        if (budget < Constants.ZERO) {
            throw new IllegalArgumentException(
                ExceptionMessage.INVALID_BUDGET_NOT_POSITIVE.getMessage());
        }
    }


}
