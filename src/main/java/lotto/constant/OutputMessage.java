package lotto.constant;

public enum OutputMessage {
    NUMBER_OF_LOTTO_BOUGHT("%d개를 구매했습니다."),
    PROFIT_RATE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
