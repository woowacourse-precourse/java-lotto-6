package lotto.domain;

public enum LottoRank {
    FIRST_PRIZE(2000000000),
    SECOND_PRIZE(30000000),
    THIRD_PRIZE(1500000),
    FOURTH_PRIZE(50000),
    FIFTH_PRIZE(5000),
    NO_PRIZE(0);

    private final long money;

    private LottoRank(long money) {
        this.money = money;
    }

    public static LottoRank getRank(int winningInLotto, boolean bonusInLotto) {
        if (winningInLotto == 6) {
            return LottoRank.FIRST_PRIZE;
        } else if (winningInLotto == 5 && bonusInLotto) {
            return LottoRank.SECOND_PRIZE;
        } else if (winningInLotto == 5) {
            return LottoRank.THIRD_PRIZE;
        } else if (winningInLotto == 4) {
            return LottoRank.FOURTH_PRIZE;
        } else if (winningInLotto == 3) {
            return LottoRank.FIFTH_PRIZE;
        }
        return LottoRank.NO_PRIZE;
    }

    public long getMoney() {
        return money;
    }
}
