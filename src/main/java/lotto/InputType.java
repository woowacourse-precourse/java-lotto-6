package lotto;

public enum InputType {

    MONEY("구입 금액을 입력해 주세요."),
    WINNINGNUMBER("당첨 번호를 입력해 주세요."),
    BONUSNUMBER("보너스 번호를 입력해 주세요.");

    private String inputMessage;
    private InputType(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
