package lotto.view;

public class InputValidator {
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식 입력이 아닙니다.";
    private static final String EMPTY_INPUT_MESSAGE = "입력이 빈칸입니다.";
    private static final String EMPTY = "";

    public static int validateBuyAmount(String inputBuyAmount) {
        validateEmpty(inputBuyAmount);
        int buyAmount = convertStringToInteger(inputBuyAmount);
        return buyAmount;
    }

    private static int convertStringToInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT_MESSAGE);
        }
    }

    private static void validateEmpty(String input) {
        if (input.equals(EMPTY)) {
            throw new IllegalArgumentException(EMPTY_INPUT_MESSAGE);
        }
    }
}