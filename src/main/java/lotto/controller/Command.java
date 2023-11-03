package lotto.controller;

public enum Command {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    BUY_LOTTO(null);

    private final String message;

    Command(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
