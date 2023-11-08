package lotto.constants;

public enum OutputMessage {
    PRINT_BUY_LOTTO_SIZE("개를 구매했습니다."),
    PRINT_RESULT_PREVIOUS_MESSAGE("당첨 통계\n" + "---");

    private String outputMessage;
    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    // Getter
    public String getOutputMessage() {
        return outputMessage;
    }
}
