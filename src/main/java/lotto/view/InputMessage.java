package lotto.view;

public enum InputMessage {
    HOW_MUCH_MONEY_FOR_LOTTO_PURCHASE("구입금액을 입력해 주세요.");



    private final String inputMessage;

    InputMessage(String inputMessage) {
        this.inputMessage = inputMessage;
    }

    public String getInputMessage() {
        return inputMessage;
    }
}
