package lotto.values;

public enum WinningMessage {
    WINNING_FIFTH_MESSAGE("3개 일치 (5,000원) - %d개\n"),
    WINNING_FOURTH_MESSAGE("4개 일치 (50,000원) - %d개\n"),
    WINNING_THIRD_MESSAGE("5개 일치 (1,500,000원) - %d개\n"),
    WINNING_SECOND_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n"),
    WINNING_FIRST_MESSAGE("6개 일치 (2,000,000,000원) - %d개\n");

    private final String message;

    WinningMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
