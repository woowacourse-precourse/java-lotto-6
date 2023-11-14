package lotto.message;

public enum RequestMessage {

    REQUEST_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS_MESSAGE("\n당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("\n보너스 번호를 입력해 주세요.");

    private final String message;

    RequestMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
