package lotto.domain;

public enum Message {
    ERROR("[ERROR] "),
    INPUT_COST("구입금액을 입력해 주세요."),
    PURCHASE_COMMENT("\n%d개를 구매했습니다.\n"),
    INPUT_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요.");
    private String message;

    Message(String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }

    public final String getErrorMessage() {
        return ERROR + message;
    }
}
