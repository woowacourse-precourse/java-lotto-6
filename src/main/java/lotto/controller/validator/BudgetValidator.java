package lotto.controller.validator;

import static lotto.model.LottoGenerator.LOTTO_TICKET_PRICE;

public class BudgetValidator implements InputValidator {
    // Singleton
    private static BudgetValidator budgetValidator;

    private BudgetValidator() {
    }

    public static BudgetValidator getInstance() {
        if (budgetValidator == null) {
            budgetValidator = new BudgetValidator();
            return budgetValidator;
        }
        return budgetValidator;
    }

    @Override
    public void validate(String userInput) {
        validateInteger(userInput);
        int number = Integer.parseInt(userInput);
        validatePositiveInteger(number);
        validateDividedByLottoTicketPrice(number);
    }

    public void validateInteger(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_INTEGER.getMessage());
        }
    }

    public void validatePositiveInteger(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_POSITIVE_INTEGER.getMessage());
        }
    }

    public void validateDividedByLottoTicketPrice(int number) {
        if (number % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.NOT_DIVIDED_BY_LOTTO_TICKET_PRICE.getMessage());
        }
    }
}
