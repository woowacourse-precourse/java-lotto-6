package lotto.util;

public enum Ranking {
    FIFTH(3, 5000, "3개 일치 (5,000원)"),
    FOURTH(4, 50000, "4개 일치 (50,000원)"),
    THIRD(5, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6, 2000000000, "6개 일치 (2,000,000,000원)");

    private final int matchNumber;
    private final int prize;
    private final String message;

    Ranking(int matchNumber, int prize, String message) {
        this.matchNumber = matchNumber;
        this.prize = prize;
        this.message = message;
    }

    public int getMatchNumber() {
        return matchNumber;
    }

    public int getPrize() {
        return prize;
    }

    public String getMessage() {
        return message;
    }
}
