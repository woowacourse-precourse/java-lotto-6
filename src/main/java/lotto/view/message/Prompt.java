package lotto.view.message;

public enum Prompt {
    PURCHASE_AMOUNT("구입금액"
            + " 입력해 주세요.");

    private String message;

    Prompt(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
