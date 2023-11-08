package output;

public enum OutputMessage {
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
