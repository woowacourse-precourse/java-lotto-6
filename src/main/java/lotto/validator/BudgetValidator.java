package lotto.validator;

import static lotto.model.lotto.LottoConstant.LOTTO_PRICE;

import lotto.exception.budget.BudgetDivisionException;
import lotto.exception.budget.BudgetRangeException;

public class BudgetValidator {
    // 구매 금액 비즈니스 로직 검증

    public static void validateBudgetRange(int budget) {
        if (budget < LOTTO_PRICE.getValue()) {
            throw new BudgetRangeException();
        }
    }

    public static void validateBudgetDivision(int budget) {
        if (budget % LOTTO_PRICE.getValue() != 0) {
            throw new BudgetDivisionException();
        }
    }


}
