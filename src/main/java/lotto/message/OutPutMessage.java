package lotto.message;


public enum OutPutMessage {
    OUTPUT_PURCHASE_QUANTITY("\n%s개를 구매했습니다."),
    OUTPUT_STATISTICS("\n당첨 통계\n---"),
    OUTPUT_MATCH_COUNT("%d개 일치 (%,d원) - %,d개"),
    OUTPUT_MATCH_COUNT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%,d원) - %,d개"),
    OUTPUT_TOTAL("총 수익률은 %,.1f%%입니다.");

    private final String message;

    OutPutMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}



