package lotto.domain;

public enum WinningRank {
    FIRST(6, false, 2000000000, "6개 일치"),
    SECOND(5, true, 30000000, "5개 일치, 보너스 볼 일치"),
    THIRD(5, false, 1500000, "5개 일치"),
    FOURTH(4, false, 50000, "4개 일치"),
    FIFTH(3, false, 5000, "3개 일치"),

    private final int match;
    private final boolean isBonus;
    private final int prize;
    private final String message;

    WinningRank(int match, boolean isBonus, int prize, String message){
        this.match = match;
        this.isBonus = isBonus;
        this.prize = prize;
        this.message = message;
    }
}
