package lotto.constant;

public enum OutputMessage {
    SHOW_RESULT("당첨 통계"),
    DIVIDING_LINE("---"),
    THREE_WIN_MESSAGE("3개 일치 (5,000원) - "),
    FOUR_WIN_MESSAGE("4개 일치 (50,000원) - "),
    FIVE_WIN_MESSAGE("5개 일치 (1,500,000원) - "),
    FIVE_WIN_WITH_BONUS_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    LOTTO_WIN_MESSAGE("6개 일치 (2,000,000,000원) - ");

    private final String outputMessage;

    private OutputMessage(String outputMessage) {
        this.outputMessage = outputMessage;
    }

    public String getOutputMessage() {
        return outputMessage;
    }
}
