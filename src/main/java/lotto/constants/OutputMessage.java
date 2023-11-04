package lotto.constants;

public enum OutputMessage {
    OUTPUT_MESSAGE("당첨 통계"),
    OUTPUT_MESSAGE_RESULT("%d개 일치"),
    OUTPUT_MESSAGE_BONUS(", 보너스 볼 일치 "),
    OUTPUT_MESSAGE_MONEY("(%s)원 - %d개");


    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
