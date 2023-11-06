package lotto.validation;

public class LottoValidation {

    public static final String ERROR_NULL = "[ERROR] 값을 입력해주세요.";

    public static final String ERROR_GAP = "[ERROR] 공백 없이 입력해주세요.";

    public static final String ERROR_ONLY_POSITIVE_INTEGER = "[ERROR] 음수를 제외한 숫자를 입력해주세요.";

    public static final String ERROR_THOUSAND_UNIT = "[ERROR] 1,000원 단위로 입력해주세요.";

    public void validatePurchaseAmount(String userInput) {
        validateNull(userInput);
        validateGap(userInput);
        validateOnlyPositiveInteger(userInput);
        validateThousandUnit(userInput);
    }

    public void validateNull(String userInput) {
        if (userInput == null || userInput.isBlank()) {
            throw new IllegalArgumentException(ERROR_NULL);
        }
    }

    public void validateGap(String userInput) {
        if (userInput.contains(" ")) {
            throw new IllegalArgumentException(ERROR_GAP);
        }
    }

    public void validateOnlyPositiveInteger(String userInput) {
        if (!userInput.matches("\\d+")) {
            throw new IllegalArgumentException(ERROR_ONLY_POSITIVE_INTEGER);
        }
    }

    public void validateThousandUnit(String userInput) {
        if (Integer.parseInt(userInput) % 1000 != 0 || Integer.parseInt(userInput) == 0) {
            throw new IllegalArgumentException(ERROR_THOUSAND_UNIT);
        }
    }
}
