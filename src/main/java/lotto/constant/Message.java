package lotto.constant;

public enum Message {
    PURCHASE_AMOUNT_PROMPT("구입금액을 입력해 주세요."),
    PURCHASE_AMOUNT_MESSAGE("%d개를 구매했습니다."),
    WINNING_NUMBER_PROMPT("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_PROMPT("보너스 번호를 입력해 주세요."),
    WINNING_STATS("당첨 통계\n---\n"),

    WINNING_CASE_MESSAGE("""
                3개 일치 (5,000원) - %d개\n
            4개 일치 (50,000원) - %d개\n
            5개 일치 (1,500,000원) - %d개\n
            5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n
            6개 일치 (2,000,000,000원) - %d개\n
            """);

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
