package lotto.constant.message;

public enum InputMessage {
    PURCHASE_PRICE("구입금액을 입력해 주세요."),
    WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    DELIMITER(",");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
