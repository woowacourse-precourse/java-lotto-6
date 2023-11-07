package lotto.enums;

public enum InputMessage {
    MONEY_TO_BUY_LOTTO("구입 금액을 입력해 주세요."),
    WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
