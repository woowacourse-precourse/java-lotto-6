package lotto.view;

public enum ConstantMessage {
    // Request
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ConstantMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
