package util;

public enum OutputMessage {

    SHOW_AMOUNT_OF_LOTTO("개를 구매했습니다"),
    SHOW_TOTAL_RESULT("당첨 통계"),
    DIVIDER("---");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
