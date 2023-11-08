package lotto.message;

public enum ResultMessage {
    WINNING_STATISTICS("당첨 통계"),
    DIVIDED_LINE("---"),
    TOTAL_YIELD("총 수익률은 %.1f%%입니다."),
    OTHERS_GRADE_PATTERN("%d개 일치 (%s원) - %d개"),
    SECOND_GRADE_PATTERN("%d개 일치, 보너스 볼 일치 (%s원) - %d개");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
