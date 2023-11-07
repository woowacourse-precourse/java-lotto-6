package System;
public enum Exception {
    LOTTO_PURCHASE_EXCEPTION("로또 구매 금액은 1,000원 단위로 입력해주세요.");

    Exception(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }

    private final String message;
}
