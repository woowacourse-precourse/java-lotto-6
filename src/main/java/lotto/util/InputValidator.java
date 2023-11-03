package lotto.util;

public class InputValidator {
    private static final String NO_A_NUMBER_MESSAGE = "로또 금액은 숫자여야 합니다";
    private static final String NUMBER_REGEX = "[0-9]+";

    public void validatePrice(String inputPrice) {
        if (isNumber(inputPrice) == false) {
            throw new IllegalArgumentException(NO_A_NUMBER_MESSAGE);
        }
    }

    private boolean isNumber(String inputPrice) {
        if (inputPrice.matches(NUMBER_REGEX)) {
            return true;
        }

        return false;
    }
}
