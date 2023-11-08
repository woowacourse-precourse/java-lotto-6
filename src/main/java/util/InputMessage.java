package util;

public enum InputMessage {
    ENTER_PRICE("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBERS("보너스 번호를 입력해 주세요.");

    private final String inputMessage;

    InputMessage(String msg) {
        this.inputMessage = msg;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
