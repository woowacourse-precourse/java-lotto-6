package lotto.view;

public enum OutputMessage {

    OUTPUT_PURCHASE_AMOUNT_MESSAGE("%d개를 구입했습니다.");

    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessage(int value) {
        return String.format(this.message, value);
    }
}
