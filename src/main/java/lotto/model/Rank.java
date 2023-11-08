package lotto.model;

public enum Rank {
    FIRST(2000000000, 6, false, 0),
    SECOND(30000000, 5, true, 0),
    THIRD(1500000, 5, false, 0),
    FORTH(50000, 4, false, 0),
    FIFTH(5000, 3, false, 0);

    private int price;
    private int lotto;
    private boolean bonus;
    private int amount;

    Rank(int price, int lotto, boolean bonus, int amount) {
        this.price = price;
        this.lotto = lotto;
        this.bonus = bonus;
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public int checkPrice(int amountOfLotto, boolean isBonus) {
        int canGetPrice = 0;
        if (lotto == amountOfLotto && bonus == isBonus) {
            amount++;
            canGetPrice = price;
        }
        return canGetPrice;
    }
}
