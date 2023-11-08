package lotto.utils;

public enum Match {
    THREE_MATCH("3개 일치", 5000),
    FOUR_MATCH("4개 일치", 50000),
    FIVE_MATCH("5개 일치", 1500000),
    BONUS_MATCH("5개 일치, 보너스 볼 일치", 30000000),
    SIX_MATCH("6개 일치", 2000000000);

    private final String message;
    private final int prize;

    Match(String message, int prize) {
        this.message = message;
        this.prize = prize;
    }

    public String getMessage() {
        return this.message;
    }

    public int getPrize() {
        return this.prize;
    }

}
