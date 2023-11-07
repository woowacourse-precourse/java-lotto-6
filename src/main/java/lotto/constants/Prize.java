package lotto.constants;

public enum Prize {
    FIRST(1, 6, 2_000_000_000),
    SECOND(2, 5, 30_000_000),
    THIRD(3, 5, 1_500_000),
    FOURTH(4, 4, 50_000),
    FIFTH(5, 3, 5_000);

    private final int rank; // 순위
    private final int match; // 일치하는 숫자 개수
    private final int money; // 상금 금액

    Prize(int rank, int match, int money) {
        this.rank = rank;
        this.match = match;
        this.money = money;
    }

    public int getRank() {
        return rank;
    }

    public int getMatch() {
        return match;
    }

    public int getMoney() {
        return money;
    }
}