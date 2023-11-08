package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Budget;
import lotto.utils.ErrorMessage;

public class BudgetService extends CreateService {

    public Budget createBudget() {
        Object budget = this.create();

        return (Budget) budget;
    }

    @Override
    public Object createObject(final Object... inputs) {
        String inputBudget = Console.readLine();
        budgetIntegerValidation(inputBudget);

        return new Budget(Integer.parseInt(inputBudget));
    }

    private void budgetIntegerValidation(final String inputBudget) {
        if (inputBudget.length() == 0) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY.getErrorMessage());
        }

        try {
            Integer.parseInt(inputBudget);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ErrorMessage.NON_INTEGER_VALUE.getErrorMessage());
        }
    }
}
