package lotto.Util;

public enum WinningStatisticsMessage {
    THREE_MATCH("3개 일치 (5,000원) - "),
    FOUR_MATCH("4개 일치 (50,000원) - "),
    FIVE_MATCH("5개 일치 (1,500,000원) - "),
    FIVE_BONUS_MATCH("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH("6개 일치 (2,000,000,000원) - ");

    private final String message;

    WinningStatisticsMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
