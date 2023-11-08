package lotto;

public enum Winnings {
    FIRST_PRIZE(2000000000, 1),
    SECOND_PRIZE(30000000, 2),
    THIRD_PRIZE(1500000, 3),
    FOURTH_PRIZE(50000, 4),
    FIFTH_PRIZE(5000, 5);

    private final int money;
    private final int rank;

    Winnings(int money, int rank) {
        this.money = money;
        this.rank = rank;
    }

    public int getPrize() {
        return money;
    }

    public int gerRank() {
        return rank;
    }
}
