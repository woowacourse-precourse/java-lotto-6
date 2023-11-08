package lotto.validator.system.domain;

import lotto.validator.system.SystemValidator;
import lotto.view.message.exception.BudgetInputErrorMessage;

public class BudgetValidator extends SystemValidator {
    public static void validateBudget(int budget){
        if(isLessThanMinimumBudget(budget)){
            displayMessageAndThrowException(BudgetInputErrorMessage.LESS_THAN_1000);
        }
        if(isNotDivisibleByThousand(budget)) {
            displayMessageAndThrowException(BudgetInputErrorMessage.DIVISIBLE_BY_THOUSAND);
        }
    }

    private static void displayMessageAndThrowException(BudgetInputErrorMessage message){
        message.displayMessage();
        throw new IllegalArgumentException(message.getMessage());
    }
}
