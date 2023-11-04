package lotto.controller;

public enum Command {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    BUY_LOTTO,
    OUTPUT_USER_LOTTO;

    private String message;
    Command() {};
    Command(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
