package lotto.constant;

public enum OutputText {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    OutputText(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
