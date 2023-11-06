package lotto.View.InputValidator;

import static lotto.Message.InputValidatorPrompt.ASK_BUDGET_IN_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_MORE_THAN_MINIMUM;
import static lotto.Message.InputValidatorPrompt.ASK_POSITIVE_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_BUDGET_WITH_THOUSANDS_INCREMENT;
import static lotto.Message.PriceConstants.MINIMUM_BUDGET;
import static lotto.Message.PriceConstants.ZERO_BUDGET;

import lotto.View.Validator;


public class BudgetInputValidator implements Validator {

    // TODO: 최소 금액이 수정될 때를 대비한 코드 리팩토링
    // TODO: 예외 발생 및 처리하게

    public void validate(String budgetInput){

        isNumber(budgetInput);
        isPositiveNumber(budgetInput);
        isUpperMinBudget(budgetInput);
        canDivideByThousand(budgetInput);

        return ;
    }

    public void isNumber(String budgetInput) throws IllegalArgumentException{
        try {
            Integer.parseInt(budgetInput);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(ASK_BUDGET_IN_NUMBER.getMessage());
        }
    }

    public void isPositiveNumber(String budgetInput) throws IllegalArgumentException{
        if(Integer.parseInt(budgetInput) <= ZERO_BUDGET.getPrice()) {
            throw new IllegalArgumentException(ASK_POSITIVE_NUMBER.getMessage());
        }
    }

    public void isUpperMinBudget(String budgetInput) throws IllegalArgumentException{
        if(Integer.parseInt(budgetInput) < MINIMUM_BUDGET.getPrice()){
            throw new IllegalArgumentException(ASK_MORE_THAN_MINIMUM.getMessage());
        }
    }

    public void canDivideByThousand(String budgetInput) throws IllegalArgumentException{
        if((Integer.parseInt(budgetInput) % MINIMUM_BUDGET.getPrice()) != 0){
            throw new IllegalArgumentException(ASK_BUDGET_WITH_THOUSANDS_INCREMENT.getMessage());
        }
    }

}
