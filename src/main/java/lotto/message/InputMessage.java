package lotto.message;

public enum InputMessage {
    INPUT_AMOUNT_OF_PAYMENT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요.(번호는 쉼표(,) 기준으로 구분)"),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
