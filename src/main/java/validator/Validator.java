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
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("숫자를 입력해 주세요.");
        }
    }

    public static void validateSeparatedByComma(String winningNumbers) {
        if (!hasComma(winningNumbers)) {
            throw new IllegalArgumentException("콤마(,)로 숫자를 구분해 주세요.");
        }
        String[] separatedWinningNumbers = winningNumbers.split(",");
        for (String winningNumber : separatedWinningNumbers) {
            if (!isNumeric(winningNumber)) {
                throw new IllegalArgumentException("당첨 번호 6개를 콤마(,)로 구분해 주세요.");
            }
        }
    }

    public static boolean hasComma(String winningNumbers) {
        return winningNumbers.contains(",");
    }

    public static boolean isNumeric(String input) {
        return input.matches(ONLY_NUMBER_REGEX);
    }
}
