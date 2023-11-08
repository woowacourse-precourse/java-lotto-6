package lotto.Domain.Constants;

public enum PrizePot {

    THREE_CORRECT_PRIZE(5_000),
    FOUR_CORRECT_PRIZE(50_000),
    FIVE_CORRECT_PRIZE(1_500_000),
    FIVE_CORRECT_AND_LUCKY_NUM_PRIZE(30_000_000),
    SIX_CORRECT_PRIZE(2_000_000_000);

    private final long won;

    PrizePot(long won) {
        this.won = won;
    }

    public long getWon(){
        return won;
    }
}
