package lotto.validator.system;

import lotto.view.message.exception.BudgetInputErrorMessage;

public class BudgetValidator extends SystemValidator{
        public static void validateBudget(int budget){
            if(isLessThanMinimumBudget(budget)){
                throw new IllegalArgumentException(BudgetInputErrorMessage.LESS_THAN_1000.getMessage());
            }
            if(isNotDivisibleByThousand(budget)){
                throw new IllegalArgumentException(BudgetInputErrorMessage.DIVISIBLE_BY_THOUSAND.getMessage());
            }
        }
}
