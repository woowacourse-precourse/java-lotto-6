package lotto.constants;

public enum InputMessage {
    INPUT_MESSAGE_BUY_LOTTO_PRICE("구입 금액을 입력해 주세요."),
    INPUT_MESSAGE_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_MESSAGE_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String inputMessage;


    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }
    @Override
    public String toString() {
        return inputMessage;
    }
}
