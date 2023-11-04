package lotto.view.message;

public enum PrintMessage {

    // InputView
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요.");

    private final String message;

    private PrintMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
