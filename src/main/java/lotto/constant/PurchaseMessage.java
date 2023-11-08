package lotto.constant;

public enum PurchaseMessage {
    ASK_PURCHASE_PRICE("구입금액을 입력해주세요."),
    BUY_RECEIPT("%s개를 구매했습니다.");


    private final String message;

    PurchaseMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }


}

