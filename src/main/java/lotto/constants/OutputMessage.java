package lotto.constants;

public enum OutputMessage {
    PRINT_BUY_LOTTO_SIZE("개를 구매했습니다."),
    PRINT_RESULT_PREVIOUS_MESSAGE("당첨 통계\n" + "---"),
    PRINT_FIRST_PRIZE("6개 일치 (2,000,000,000원) - "),
    PRINT_SECOND_PRIZE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_THIRD_PRIZE("5개 일치 (1,500,000원) - "),
    PRINT_FOURTH_PRIZE("4개 일치 (50,000원) - "),
    PRINT_FIFTH_PRIZE("3개 일치 (5,000원) - ");

    private String outputMessage;
    OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
