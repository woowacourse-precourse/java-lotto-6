package lotto.constant;

public enum OutputMessage {
    INPUT_PRICE("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    BUY_COUNT("개를 구매했습니다."),
    RESULT("당첨 통계\n---");

    private final String message;

    private OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
