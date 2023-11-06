package lotto.constants;

public enum SystemMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");
    String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
