package lotto.validator;

public class PurchaseAmountValidator {

    public int validateAndParse(String userInput) {
        validateNotEmpty(userInput);
        return validateAndParseInteger(userInput);
    }

    private void validateNotEmpty(String userInput) {
        if (userInput.isEmpty()) {
            throw new NumberFormatException();
        }
    }

    private int validateAndParseInteger(String userInput) {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new NumberFormatException();
        }
    }
}
