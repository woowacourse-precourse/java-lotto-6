package lotto.input;

public enum InputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
