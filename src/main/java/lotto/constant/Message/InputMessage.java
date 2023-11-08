package lotto.constant.Message;

public enum InputMessage {
    REQUEST_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    REQUEST_LOTTO_NUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.");


    private final String inputMessage;

    InputMessage(String inputmessage) {
        this.inputMessage = inputmessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
