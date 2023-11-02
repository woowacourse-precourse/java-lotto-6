package lotto;

public class InputValidator {

    public static void isLottoDigit(String input) {
        if (isDigit(input)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_MESSAGE.getMessage());
        }
    }

    public void checkLottoBlank(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_BLANK_MESSAGE.getMessage());
        }
    }

    public void checkLottoEmpty(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ErrorMessage.INPUT_EMPTY_MESSGAE.getMessage());
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    private static boolean isEmpty(String input) {
        return input.isEmpty();
    }

    private static boolean isDigit(String input) {
        return !Character.isDigit(input.charAt(0));
    }
}
