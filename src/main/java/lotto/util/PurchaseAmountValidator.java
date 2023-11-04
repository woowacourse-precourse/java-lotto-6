package lotto.util;

import static lotto.domain.lotto.LottoConstants.LOTTO_PRICE;

public class PurchaseAmountValidator {

    public void validate(String userInput) throws IllegalArgumentException {
        validateEmpty(userInput);
        validateDigit(userInput);
        validateRange(userInput);
        validateThousand(userInput);
    }

    private void validateEmpty(String userInput) {
        if (userInput.isBlank()) {
            throw new IllegalArgumentException(Message.EMPTY_INPUT.getMessage());
        }
    }

    private void validateDigit(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Message.INVALID_INTEGER.getMessage());
        }
    }

    private void validateRange(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number <= 0) {
            throw new IllegalArgumentException(Message.INVALID_INTEGER.getMessage());
        }
    }

    private void validateThousand(String userInput) {
        int number = Integer.parseInt(userInput);
        if (number % LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException(Message.NOT_THOUSAND.getMessage());
        }
    }

    private enum Message {
        INVALID_INTEGER("[ERROR]자연수를 입력해주세요."),
        EMPTY_INPUT("[ERROR]구매금액을 입력해주세요."),
        NOT_THOUSAND("[ERROR]1,000단위로 입력해주세요.");

        private final String message;
        Message(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
