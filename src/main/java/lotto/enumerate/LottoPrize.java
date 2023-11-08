package lotto.enumerate;

public enum LottoPrize {
    MATCH_3(5000),
    MATCH_4(50000),
    MATCH_5(1500000),
    MATCH_5_PLUS_BONUS(30000000),
    MATCH_6(2000000000);

    private final int prize;

    LottoPrize(int prize) {
        this.prize = prize;
    }

    public int getPrize() {
        return prize;
    }

}
