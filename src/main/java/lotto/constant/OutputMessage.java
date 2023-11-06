package lotto.constant;

public enum OutputMessage {
    INFORM_QUANTITY_MESSAGE("개를 구매했습니다."),
    SHOW_RESULT("당첨 통계"),
    DIVIDING_LINE("---"),
    FIFTH_WIN_MESSAGE("3개 일치 (5,000원) - "),
    FOURTH_WIN_MESSAGE("4개 일치 (50,000원) - "),
    THIRD_WIN_MESSAGE("5개 일치 (1,500,000원) - "),
    SECOND_WIN_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    LOTTO_WIN_MESSAGE("6개 일치 (2,000,000,000원) - ");

    private final String outputMessage;

    private OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
