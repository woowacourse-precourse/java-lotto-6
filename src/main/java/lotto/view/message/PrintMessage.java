package lotto.view.message;

public enum PrintMessage {

    // InputView
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),

    // OutputView
    LOTTO_COUNT_OUTPUT_MESSAGE("개를 구입했습니다.");

    private final String message;

    private PrintMessage (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
