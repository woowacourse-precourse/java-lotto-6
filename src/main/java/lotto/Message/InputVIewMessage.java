package lotto.Message;

public enum InputVIewMessage {

    INPUTPERCHASEPROMPT("구입금액을 입력해 주세요."),
    INPUTWINNINGNUMBERPROMPT("\n당첨 번호를 입력해 주세요."),
    INPUTBONUSNUMBERPROMPT("\n보너스 번호를 입력해 주세요.");
    private String message;

    InputVIewMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
