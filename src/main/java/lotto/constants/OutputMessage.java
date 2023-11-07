package lotto.constants;

public enum OutputMessage implements Message {

    ANNOUNCE_PURCHASE_QUANTITY_FORMAT("%s개를 구매했습니다."),
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
