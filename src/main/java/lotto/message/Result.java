package lotto.message;

public enum Result {
    ANNOUNCE_INIT("당첨 통계\n---"),
    FIFTH_PLACE("3개 일치 (5,000원) - %d개"),
    FOURTH_PLACE("4개 일치 (50,000원) - %d개"),
    THIRD_PLACE("5개 일치 (1,500,000원) - %d개"),
    SECOND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_PLACE("6개 일치 (2,000,000,000원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    Result(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
