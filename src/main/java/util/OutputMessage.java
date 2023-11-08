package util;

public enum OutputMessage {
    SHOW_AMOUNT_OF_LOTTO("개를 구매했습니다."),
    SHOW_TOTAL_RESULT("당첨 통계"),
    DIVIDER("---"),
    TOTAL_RATE_OF_RETURN("총 수익률은 "),
    END_OF_RATE_WORD("%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
