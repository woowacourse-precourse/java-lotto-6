package lotto.output;

public enum OutputMessage {
    FIRST_PRIZE("6개 일치 (2,000,000,000원)"),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    THIRD_PRIZE("5개 일치 (1,500,000원)"),
    FOURTH_PRIZE("4개 일치 (50,000원)"),
    FIFTH_PRIZE("3개 일치 (5,000원)"),
    LOTTO_AMOUNT("개를 구매했습니다."),
    LOTTO_RESULT("당첨 통계\n---\n");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
