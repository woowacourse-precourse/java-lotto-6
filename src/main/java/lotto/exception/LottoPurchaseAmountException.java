package lotto.exception;

public class LottoPurchaseAmountException {
    private static final String ERROR = "[ERROR]";
    private static final String CAN_DIVIDE_THOUSAND_MESSAGE = " 구매 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String IS_NUMBER_MESSAGE = " 구매 금액은 숫자를 입력해주셔야 합니다.";
    private static final String IS_BLANK_MESSAGE = " 구매 금액을 공백으로 입력하셨습니다.";

    public LottoPurchaseAmountException(String input) {
        isNumber(input);
        isDivideThousand(input);
        isBlank(input);
    }

    private void isDivideThousand(String input) {
        int purchaseAmount = Integer.parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR + CAN_DIVIDE_THOUSAND_MESSAGE);
        }
    }

    private void isNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR + IS_NUMBER_MESSAGE);
        }

    }

    private void isBlank(String input) {
        if (input.trim().isEmpty()) {
            throw new IllegalArgumentException(ERROR + IS_BLANK_MESSAGE);
        }
    }
}
