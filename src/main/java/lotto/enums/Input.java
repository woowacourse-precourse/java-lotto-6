package lotto.enums;

public enum Input {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호을 입력해 주세요."),
    ;

    private final String message;

    Input(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
