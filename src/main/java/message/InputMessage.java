package message;

public enum InputMessage {
    PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");

    String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
