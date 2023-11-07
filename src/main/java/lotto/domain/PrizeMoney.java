package lotto.domain;

public enum PrizeMoney {
    THREE_MATCH_PRIZE_MONEY(5000),
    FOUR_MATCH_PRIZE_MONEY(50000),
    FIVE_MATCH_PRIZE_MONEY(150000),
    FIVE_AND_BONUS_MATCH_PRIZE_MONEY(30000000),
    SIX_MATCH_PRIZE_MONEY(2000000000);

    private final int prize;

    private PrizeMoney(int prize) { this.prize = prize; }
    public int getPrize() { return prize; }
}
