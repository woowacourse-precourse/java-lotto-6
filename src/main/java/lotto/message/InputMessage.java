package lotto.message;

public enum InputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_RESULT("%s개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_RESULT("당첨 통계\n---");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getValue() {
        return this.message;
    }
}
