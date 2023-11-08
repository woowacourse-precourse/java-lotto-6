package output;

public enum OutputMessage {
    COMMA(","),
    GIVE_THE_WINNING_NUMBERS("\n당첨 번호를 입력해 주세요."),
    OUTPUT_PURCHASE_AMOUNT("%d개를 구매했습니다.\n"),
    OUTPUT_STATISTICS_START("\n당첨 통계\n---\n"),
    OUTPUT_MESSAGE_WITHOUT_BONUS("%d개 일치 (%s원) - %d개\n"),
    OUTPUT_MESSAGE_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PRINT_RATE_OF_RETURN("총 수익률은 %s%%입니다.\n");

    private final String outputMessage;

    OutputMessage(String outputMessage){
        this.outputMessage = outputMessage;
    }

    public String message(){
        return outputMessage;
    }
}
