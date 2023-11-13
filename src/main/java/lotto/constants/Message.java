package lotto.constants;

public enum Message {
    PURCHASE_MONEY("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    RESULT("당첨 통계\n---\n"),
    Count("개"),
    EARNINGS_RATE("총 수익률은 %,.1f%%입니다.%n"),
    COMMA(",");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
