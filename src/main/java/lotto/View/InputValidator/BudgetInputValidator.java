package lotto.View.InputValidator;

import static lotto.Constants.BudgetConstants.MAXIMUM_BUDGET;
import static lotto.Message.InputValidatorPrompt.ASK_BUDGET_NUMBER_IN_RIGHT_FORMAT;
import static lotto.Message.InputValidatorPrompt.ASK_NO_EMPTY_INPUT;
import static lotto.Message.InputValidatorPrompt.ASK_NO_WHITE_SPACE;
import static lotto.Message.InputValidatorPrompt.ASK_MORE_THAN_MINIMUM;
import static lotto.Message.InputValidatorPrompt.ASK_POSITIVE_NUMBER;
import static lotto.Message.InputValidatorPrompt.ASK_BUDGET_WITH_THOUSANDS_INCREMENT;
import static lotto.Constants.BudgetConstants.MINIMUM_BUDGET;
import static lotto.Constants.BudgetConstants.ZERO_BUDGET;
import static lotto.Message.OutputPrompt.WHITE_SPACE;

public class BudgetInputValidator {

    // TODO: 최소 금액이 수정될 때를 대비한 코드 리팩토링

    public void validate(String budgetInput){
        isNotEmpty(budgetInput);
        containsNoWhiteSpace(budgetInput);
        isNumberInRightFormat(budgetInput);
        isPositiveNumber(budgetInput);
        isUpperMinBudget(budgetInput);
        canDivideByThousand(budgetInput);
    }
    public void isNotEmpty(String budgetInput) throws IllegalArgumentException{
        if(budgetInput.isEmpty()){
            throw new IllegalArgumentException(ASK_NO_EMPTY_INPUT.getMessage());
        }
    }
    public void containsNoWhiteSpace(String budgetInput) throws IllegalArgumentException{
        if(budgetInput.contains(WHITE_SPACE.getMessage())){
            throw new IllegalArgumentException(ASK_NO_WHITE_SPACE.getMessage());
        }
    }

    public void isNumberInRightFormat(String budgetInput) throws IllegalArgumentException{
        try {
            Integer.parseInt(budgetInput);
        }
        catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException(
                    String.format(ASK_BUDGET_NUMBER_IN_RIGHT_FORMAT.getMessage(), MAXIMUM_BUDGET.getPrice()));
        }
        if(Integer.parseInt(budgetInput) > MAXIMUM_BUDGET.getPrice()){
            throw new IllegalArgumentException(
                    String.format(ASK_BUDGET_NUMBER_IN_RIGHT_FORMAT.getMessage(), MAXIMUM_BUDGET.getPrice()));
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
