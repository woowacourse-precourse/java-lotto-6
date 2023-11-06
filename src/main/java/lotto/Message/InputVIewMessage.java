package lotto.Message;

public enum InputVIewMessage {
    INPUT_PURCHASE_PROMPT("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER_PROMPT("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_PROMPT("\n보너스 번호를 입력해 주세요.");

    private String message;

    InputVIewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
