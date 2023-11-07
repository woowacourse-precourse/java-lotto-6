package lotto.message;

public enum ProcessMessage {
    INPUT_MONEY_TO_BUY_LOTTO("구입금액을 입력해 주세요."),
    LOTTO_COUNT("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    TOTAL_YIELD("총 수익률은 %.1f%%입니다."),
    OTHERS_GRADE_PATTERN("%d개 일치 "),
    SECOND_GRADE_PATTERN("%d개 일치, 보너스 볼 일치 "),
    PRIZE_MONEY_AND_MATCH_COUNT("(%s원) - %d개"),
    LINE("---");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
