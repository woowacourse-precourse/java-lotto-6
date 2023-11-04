package lotto.constant;

public enum ProcessMessage {
    PURCHASE_AMOUNT_REQUSET("구입금액을 입력해 주세요."),
    NUMBER_OF_LOTTO_TICKET("%s개를 구매했습니다."),
    NEW_LINE("\n");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    public String toValue() {
        return this.message;
    }
}
