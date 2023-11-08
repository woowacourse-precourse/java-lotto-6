package lotto.enums;

public enum OutputMsg {
    PURCHASE_QUANTITY("%d개를 구매했습니다."),
    RESULT("당첨 통계"),
    RESULT_LINE("---"),
    PROFIT("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMsg(String message) {
        this.message = message;
    }

    public String getMsg() {
        return message;
    }
}
