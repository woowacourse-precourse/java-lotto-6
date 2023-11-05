package lotto.domain;

public enum Message {
    ERROR("[ERROR] "),
    INPUT_COST("구입금액을 입력해 주세요."),
    INPUT_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBERS("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---");
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
