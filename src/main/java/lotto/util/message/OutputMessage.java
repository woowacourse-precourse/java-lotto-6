package lotto.util.message;

public enum OutputMessage {
    OUTPUT_PURCHASE_COUNT("%d개를 구매했습니다."),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n---"),
    OUTPUT_RESULT("3개 일치 (5,000원) - %d개\n" +
            "4개 일치 (50,000원) - %d개\n" +
            "5개 일치 (1,500,000원) - %d개\n" +
            "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" +
            "6개 일치 (2,000,000,000원) - %d개"),
    OUTPUT_TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

    private final String outputMessage;

    OutputMessage(String outputMessage){
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage(){
        return this.outputMessage;
    }
    public String getFormattedMessage(Object... params) {
        return String.format(outputMessage,params);
    }
}
