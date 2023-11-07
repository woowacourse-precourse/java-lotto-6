package validator;

public class Validator {
    private static final int LOTTO_PRICE = 1_000;
    private static final int REMAINDER_ZERO = 0;
    private static final String ONLY_NUMBER_REGEX = "^[0-9]*$";

    public static void validatePurchaseAmount(int spend) {
        if (spend % LOTTO_PRICE != REMAINDER_ZERO) {
            throw new IllegalArgumentException("1,000원 단위로 입력해 주세요.");
        }
    }

    public static void validateInputIsNumeric(String input) {
        if (!input.matches(ONLY_NUMBER_REGEX)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }
}
