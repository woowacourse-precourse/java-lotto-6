package lotto.View.Constants;

public enum InputViewConstant {
    ASK_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    InputViewConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
