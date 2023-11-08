package lotto.view.InputView;

public enum InputMessage {
    PRINT_PURCHASE_PRICE("구입 금액을 입력해 주세요."),
    PRINT_WINNING_NUMBERS("당첨 번호를 입력해주세요."),
    PRINT_BONUS_NUMBER("보너스 번호를 입력해주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
