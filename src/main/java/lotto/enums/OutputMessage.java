package lotto.enums;

public enum OutputMessage {
    PAY_SUCCESS_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    WINNING_RANK_FIFTH_MESSAGE("3개 일치 (5,000원) - "),
    WINNING_RANK_FOURTH_MESSAGE("4개 일치 (50,000원) - "),
    WINNING_RANK_THIRD_MESSAGE("5개 일치 (1,500,000원) - "),
    WINNING_RANK_SECOND_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_RANK_FIRST_MESSAGE("6개 일치 (2,000,000,000원) - "),
    COUNT_UNIT_MESSAGE("개");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
