package lotto.view.message;

public enum Prompt implements Messageable {
    PURCHASE_AMOUNT("구입금액"
            + " 입력해 주세요.");

    private String message;

    Prompt(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
