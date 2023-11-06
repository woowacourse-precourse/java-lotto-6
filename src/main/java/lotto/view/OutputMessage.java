package lotto.view;

public enum OutputMessage {
    REQUEST_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PURCHASE_RESULT("개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계\n---"),
    TOTAL_RETURN("총 수익률은 f%%입니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
