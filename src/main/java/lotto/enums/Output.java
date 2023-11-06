package lotto.enums;

public enum Output {
    PURCHASE_QUANTITY("%d개를 구매했습니다."),
    RESULT("당첨 통계"),
    RESULT_LINE("---"),
    PROFIT("총 수익률은 %.2f입니다.");

    private final String message;

    Output(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
