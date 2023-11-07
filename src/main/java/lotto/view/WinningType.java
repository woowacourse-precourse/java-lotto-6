package lotto.view;

public enum WinningType {
    WINNING_COUNT_3("3개 일치 (5,000원) - "),
    WINNING_COUNT_4("4개 일치 (50,000원) - "),
    WINNING_COUNT_5("5개 일치 (1,500,000원) - "),
    WINNING_COUNT_5_AND_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WINNING_COUNT_6("6개 일치 (2,000,000,000원) - ");

    private final String message;

    WinningType(String message) {
        this.message = message;
    }

    public java.lang.String getMessage() {
        return message;
    }
}
