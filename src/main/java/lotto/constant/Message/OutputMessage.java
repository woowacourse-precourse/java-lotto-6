package lotto.constant.Message;

public enum OutputMessage {
    SHOW_PURCHASED_LOTTO_NUMBER("%d개를 구매했습니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
