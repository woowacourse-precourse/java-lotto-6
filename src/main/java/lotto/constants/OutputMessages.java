package lotto.constants;

public enum OutputMessages {
    ASK_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASED_LOTTO_COUNT_MESSAGE("개를 구매했습니다."),
    ASK_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    ASK_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계\n---"),
    UNIT_MESSAGE("개"),
    TOTAL_PROFIT_RATE_MESSAGE("총 수익률은 "),
    PERCENT_PROFIT_RATE_MESSAGE("%입니다.");

    private final String message;

    OutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
