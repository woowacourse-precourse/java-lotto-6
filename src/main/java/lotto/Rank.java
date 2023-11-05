package lotto;

public enum Rank {
    FIRST("1등", 2000000000),
    SECOND("2등", 30000000),
    THIRD("3등", 1500000),
    FOURTH("4등", 50000),
    FIFTH("5등", 5000);

    private String rank;
    private int money;

    Rank(String rank, int money) {
        this.rank = rank;
        this.money = money;
    }

    public String getRank() {
        return this.rank;
    }

    public int getMoney() {
        return this.money;
    }
}
