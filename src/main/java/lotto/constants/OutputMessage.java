package lotto.constants;

public enum OutputMessage {
    LOTTO_STATISTICS("당첨 통계"),
    LINE_SEPARATOR("---"),
    PROFIT_RATE("총 수익률은 %s%%입니다.");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
