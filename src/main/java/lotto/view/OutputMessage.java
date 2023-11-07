package lotto.view;

public enum OutputMessage {

    WINNING_STATISTICS("당첨 통계"),
    DIVIDING_LINE("---"),
    BUY_IT("개를 구매했습니다."),
    CORRECT_THREE("3개 일치 (5,000원) - %d개"),
    CORRECT_FOUR("4개 일치 (50,000원) - %d개"),
    CORRECT_FIVE("5개 일치 (1,500,000원) - %d개"),
    CORRECT_FIVE_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    CORRECT_SIX("6개 일치 (2,000,000,000원) - %d개");

    private final String value;

    OutputMessage(String value) {
        this.value = value;
    }

    public String getMessage() {
        return value;
    }
}
