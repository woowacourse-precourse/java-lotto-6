package lotto.model;

import lotto.utils.Constants;
import lotto.utils.ExceptionMessage;

public record Budget(int inputMoney) {

    public Budget {
        validate(inputMoney);
    }

    private void validate(Integer inputMoney) {
        validateBudgetIsPositive(inputMoney);
        validateBudgetAmount(inputMoney);
    }

    private void validateBudgetAmount(int budget) {
        if (budget % Constants.LOTTO_PRICE != Constants.ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BUDGET_AMOUNT.getMessage());
        }
    }

    private void validateBudgetIsPositive(int budget) {
        if (budget <= Constants.ZERO) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_BUDGET_NOT_POSITIVE.getMessage());
        }
    }

    public int calculateLottoCount(){
        return inputMoney / Constants.LOTTO_PRICE;
    }
}
