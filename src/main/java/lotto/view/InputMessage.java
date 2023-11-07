package lotto.view;

public enum InputMessage {
    ENTER_TOTAL_PURCHASE_MONEY("구입금액을 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    ENTER_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요.");



    private final String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
