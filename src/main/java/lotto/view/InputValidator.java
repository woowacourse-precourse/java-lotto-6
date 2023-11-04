package lotto.view;

public class InputValidator {
    private static final String INVALID_NUMBER_FORMAT_MESSAGE = "숫자 형식 입력이 아닙니다.";
    private static final String INVALID_EMPTY_INPUT_MESSAGE = "입력이 빈칸입니다.";
    private static final String INVALID_CONTAIN_BLANK_INPUT_MESSAGE = "입력에 공백이 포함될 수 없습니다.";
    private static final String INVALID_BUY_AMOUNT_MESSAGE = "구입 금액을 1,000원 단위로 입력해주세요.";
    private static final String EMPTY = "";
    private static final char BLANK = ' ';
    private static final int THOUSAND = 1000;
    private static final int ZERO = 0;

    public static int validateBuyAmount(String inputBuyAmount) {
        validateEmpty(inputBuyAmount);
        validateContainBlank(inputBuyAmount);
        int buyAmount = convertStringToInteger(inputBuyAmount);
        validateRestZero(buyAmount);
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
            throw new IllegalArgumentException(INVALID_EMPTY_INPUT_MESSAGE);
        }
    }

    private static void validateContainBlank(String input) {
        boolean containBlank = input.chars()
                .anyMatch(ch -> ch == BLANK);

        if (containBlank) {
            throw new IllegalArgumentException(INVALID_CONTAIN_BLANK_INPUT_MESSAGE);
        }
    }

    private static void validateRestZero(int buyAmount) {
        int rest = buyAmount % THOUSAND;

        if (rest != ZERO) {
            throw new IllegalArgumentException(INVALID_BUY_AMOUNT_MESSAGE);
        }
    }
}