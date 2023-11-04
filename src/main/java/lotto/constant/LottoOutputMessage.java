package lotto.constant;

public enum LottoOutputMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_COUNT("%d개를 구매했습니다.");

    private final String message;

    LottoOutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
