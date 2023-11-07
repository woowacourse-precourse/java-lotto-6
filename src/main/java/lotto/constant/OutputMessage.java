package lotto.constant;

public enum OutputMessage {
    NEW_LINE(System.lineSeparator()),
    RESULT_INTRO("당첨 통계"),
    DIVIDE_LINE("---"),
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    WIN_COUNT_MESSAGE("개"),
    EARNING_RATE_START_MESSAGE("총 수익률은 "),
    EARNING_RATE_END_MESSAGE(" %입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
