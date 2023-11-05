package lotto.view.message;

public enum PrintMessage {

    // InputView
    PURCHASE_AMOUNT_INPUT_MESSAGE("구입금액을 입력해 주세요."),
    WIN_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),

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
