package lotto.utils;

public enum OutputMessage {
    LOTTO_OUTPUT_MESSAGE("개를 구매했습니다."),
    WINNING_STATISTIC_MESSAGE("당첨 통계\n"),
    HYPHENS("---\n"),
    RESULT_OUTPUT_FRONT_MESSAGE("총 수익률은 "),
    RESULT_OUTPUT_BACK_MESSAGE("%입니다."),
    HYPHEN(" - "),
    THREE_MATCH_MESSAGE("3개 일치 (5,000원)"),
    FOUR_MATCH_MESSAGE("4개 일치 (50,000원)"),
    FIVE_MATCH_MESSAGE("5개 일치 (1,500,000원)"),
    BONUS_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원)"),
    SIX_MATCH_MESSAGE("6개 일치 (2,000,000,000원)"),
    BRACKETS1("["),
    BRACKETS2("]");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
