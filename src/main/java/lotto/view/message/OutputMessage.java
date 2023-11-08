package lotto.view.message;

public enum OutputMessage {
    ASK_TO_INSERT_USER_MONEY("구입금액을 입력해 주세요."),
    ASK_TO_INSERT_LOTTO_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_TO_INSERT_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_NUMBER_OF_LOTTOS("개를 구매했습니다."),
    PRINT_WINNING_STATISTICS_WORD("당첨 통계"),
    PRINT_FIFTH_RANK_PRIZE_RESULT_FORMAT("3개 일치 (%s원) - %d개"),
    PRINT_FOURTH_RANK_PRIZE_RESULT_FORMAT("4개 일치 (%s원) - %d개"),
    PRINT_THIRD_RANK_PRIZE_RESULT_FORMAT("5개 일치 (%s원) - %d개"),
    PRINT_SECOND_RANK_PRIZE_RESULT_FORMAT("5개 일치, 보너스 볼 일치 (%s원) - %d개"),
    PRINT_FIRST_RANK_PRIZE_RESULT_FORMAT("6개 일치 (%s원) - %d개"),
    PRINT_RATE_OF_RETURN_RESULT_FORMAT("총 수익률은 %s%%입니다.");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}