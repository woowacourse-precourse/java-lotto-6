package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Budget;
import lotto.utils.ErrorMessage;
import lotto.utils.ErrorMessageUtil;

public class BudgetService {

    public Budget createBudget() {
        Budget budget=null;
        boolean isCompleteToCreateBudget = false;

        while(!isCompleteToCreateBudget){
            try{
                String inputBudget = Console.readLine();
                budgetIntegerValidation(inputBudget);
                budget = new Budget(Integer.parseInt(inputBudget));

                isCompleteToCreateBudget=true;
            } catch (IllegalArgumentException exception){
                System.out.print(ErrorMessageUtil.getOutputErrorMessage(exception.getMessage()));
            }
        }

        return budget;
    }

    private void budgetIntegerValidation(String inputBudget) {
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
