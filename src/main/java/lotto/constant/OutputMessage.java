package lotto.constant;

public enum OutputMessage {
    WIN_STATISTICS("당첨 통계"),
    DIVIDING_LINE("---"),
    PROFIT("총 수익률은 %s%%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage){
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
