package lotto.common;

public enum InputOutputMessages {
    INPUT_MONEY("구입금액을 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),

    OUTPUT_DASHES("---"),
    OUTPUT_STATISTICS_HEADER("당첨 통계"),
    OUTPUT_RANK_RESULT_FORMAT("%s - %s개\n"),
    OUTPUT_PURCHASED_LOTTO_COUNT_FORMAT("%s개를 구매했습니다.\n"),
    OUTPUT_TOTAL_PROFIT_RATE_FORMAT("총 수익률은 %.1f%%입니다.\n");

    private final String message;

    InputOutputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
