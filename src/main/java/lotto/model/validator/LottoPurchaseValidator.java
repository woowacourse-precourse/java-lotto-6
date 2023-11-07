package lotto.model.validator;

public class LottoPurchaseValidator {

    public static int validatePurchaseAmount(String input) throws IllegalArgumentException {
        validateEmptyInput(input);
        int parsedAmount = parseInputToInt(input);
        validatePositiveAmount(parsedAmount);
        validateMultipleOfThousand(parsedAmount);

        return parsedAmount;
    }

    private static void validateEmptyInput(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR]입력값이 비어있습니다. 다시 입력해주세요.");
        }
    }

    private static int parseInputToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR]올바른 숫자를 입력해주세요.");
        }
    }

    private static void validatePositiveAmount(int parsedAmount) {
        if (parsedAmount <= 0) {
            throw new IllegalArgumentException("[ERROR]구매 금액은 0원보다 커야 합니다. 다시 입력해주세요.");
        }
    }

    private static void validateMultipleOfThousand(int parsedAmount) {
        if (parsedAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR]로또 구매 금액은 1000원 단위로 입력해야 합니다. 다시 입력해주세요.");
        }
    }
}