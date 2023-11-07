package lotto.view;

public enum InputMessage {
    ENTER_PURCHASE_AMOUNT_PRINT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBER_PRINT("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER_PRINT("보너스 번호를 입력해 주세요.");

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
