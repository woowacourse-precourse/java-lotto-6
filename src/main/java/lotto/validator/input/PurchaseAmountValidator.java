package lotto.validator.input;

import lotto.exception.input.EmptyInputException;

public class PurchaseAmountValidator {

    public int validateAndParse(String userInput) {
        validateNotEmpty(userInput);
        return validateAndParseInteger(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new EmptyInputException("입력이 비었습니다.");
        }
    }

    private int validateAndParseInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("입력이 정수가 아닙니다.");
        }
    }
}
