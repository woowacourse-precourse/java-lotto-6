package lotto;

public enum ViewMessage {
    PAYMENT_PROMPT_MESSAGE("구입금액을 입력해 주세요."),
    NUMBER_OF_PURCHASED_FORMAT("%d개를 구매했습니다."),
    WINNING_NUMBERS_PROMPT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_PROMPT_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_MESSAGE("당첨 통계\n---"),
    RATE_OF_REVENUE_FORMAT("총 수익률은 %.1f%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String get() {
        return message;
    }
}
