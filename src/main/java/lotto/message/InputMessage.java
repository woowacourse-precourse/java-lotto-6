package lotto.message;

public enum InputMessage {

    INPUT_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_LOTTO_NUMBER("\n당첨 번호 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public String format(Object... args) {
        return String.format(message, args);
    }
}
