package lotto.view;

public enum OutputMessage {
    WINNING_STATISTICS("당첨 통계"),
    PURCHASE_X_COUNT("개를 구매했습니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
