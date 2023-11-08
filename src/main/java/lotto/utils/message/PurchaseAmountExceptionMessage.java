package lotto.utils.message;

public enum PurchaseAmountExceptionMessage {

    OUT_OF_AMOUNT_RANGE("[ERROR] 구입 금액은 1천원 ~ 1억원 까지 가능합니다."),
    INVALID_AMOUNT_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");


    private final String error;

    PurchaseAmountExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
