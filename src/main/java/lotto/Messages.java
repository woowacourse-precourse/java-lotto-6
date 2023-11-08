package lotto;

public enum Messages {
    PURCHASE_COUNT("개를 구매했습니다."),
    STATISTICS_TITLE("당첨 통계"),
    DIVIDER_LINE("---"),
    COUNT_UNIT("개"),
    FIFTH_PRIZE("3개 일치 (5,000원) - "),
    FOURTH_PRIZE("4개 일치 (50,000원) - "),
    THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    RETURN_RATIO_HEAD("총 수익률은 "),
    RETURN_RATIO_TAIL("%입니다.");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
