package lotto.util;

public enum OutputMessage {
    TOTAL_STATISTICS_TITLE("당첨 통계"),
    TOTAL_STATISTICS_MESSAGE("%s - %d개"),
    TOTAL_PARAMETER("---"),
    TOTAL_RETURN_VALUE_MESSAGE("총 수익률은 %s\\%입니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
