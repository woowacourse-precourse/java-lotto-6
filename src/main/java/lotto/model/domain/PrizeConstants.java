package lotto.model.domain;

public enum PrizeConstants {
    NOT_MATCH(0),
    ONE_MATCH(0),
    TWO_MATCH(0),
    THREE_MATCH(5000),
    FOUR_MATCH(50000),
    FIVE_MATCH(1500000),
    FIVE_MATCH_WITH_BONUS(30000000),
    SIX_MATCH(2000000000),
    ;

    private final int prize;

    PrizeConstants(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }
}
