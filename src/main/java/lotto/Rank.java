package lotto;

public enum Rank {
    FIRST("6", 2000000000, 0),
    SECOND("5B", 30000000, 0),
    THIRD("5", 1500000, 0),
    FOURTH("4", 50000, 0),
    FIFTH("3", 5000, 0),
    FAIL("0", 0, 0);


    private String rank;
    private int money;
    private int amount;

    Rank(String rank, int money, int amount) {
        this.rank = rank;
        this.money = money;
        this.amount = amount;
    }

    public String getRank() {
        return this.rank;
    }

    public int getMoney() {
        return this.money;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount() {
        this.amount++;
    }

    public Rank calcurateRank(String rank) {
        if (rank.equals(FIRST.rank)) {
            return FIRST;
        }
        if (rank.equals(SECOND.rank)) {
            return SECOND;
        }
        if (rank.equals(THIRD.rank)) {
            return THIRD;
        }
        if (rank.equals(FOURTH.rank)) {
            return FOURTH;
        }
        if (rank.equals(FIFTH.rank)) {
            return FIFTH;
        }
        return FAIL;
    }
}
