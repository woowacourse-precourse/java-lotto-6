package lotto.constants;

public enum InputMessage {
    REQUEST_AMOUNT("구입금액을 입력해 주세요."),
    REQUEST_PRIZE_NUM("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUM("보너스 번호를 입력해 주세요.");

    private String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    // Getter
    public String getInputMessage() {
        return inputMessage;
    }
}