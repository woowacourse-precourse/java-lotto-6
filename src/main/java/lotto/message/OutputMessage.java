package lotto.message;

public enum OutputMessage {
    NUMBER_OF_PURCHASES("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계\n---"),
    FIRST_PLACE("3개 일치 (5,000원) - %d개"),
    SECOND_PLACE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개"),
    FOURTH_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIFTH_PLACE("6개 일치 (2,000,000,000원) - %d개"),
    RATE_OF_RETURN("총 수익률은 %d%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int number) {
        return String.format(message, number);
    }
}
