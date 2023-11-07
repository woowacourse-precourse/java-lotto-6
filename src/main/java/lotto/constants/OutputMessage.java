package lotto.constants;

public enum OutputMessage implements Message {

    ANNOUNCE_PURCHASE_QUANTITY_FORMAT("%s개를 구매했습니다."),
    ANNOUNCE_WINNING_STATISTICS_START("당첨 통계"),

    DIVISION_LINE("---"),
    ;


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
