package lotto.constant;

public enum ResultMessage {
    STAT("%d개 일치 (%,d원) - "),
    BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - "),
    STAT_SUFFIX("%,d개"),
    NULL("");

    private final String message;

    ResultMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
