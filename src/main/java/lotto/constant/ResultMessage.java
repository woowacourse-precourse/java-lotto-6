package lotto.constant;

public enum ResultMessage {
    FIFTH_STATISTIC("3개 일치 (5,000원) - %d개"),
    FOURTH_STATISTIC("4개 일치 (50,000원) - %d개"),
    THIRD_STATISTIC("5개 일치 (1,500,000원) - %d개"),
    SECOND_STATISTIC("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
    FIRST_STATISTIC("6개 일치 (2,000,000,000원) - %d개");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
