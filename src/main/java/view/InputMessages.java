package view;

public enum InputMessages {
    PURCHASE_MESSAGE("구입금액을 입력해 주세요.");

    private String message;

    private InputMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
