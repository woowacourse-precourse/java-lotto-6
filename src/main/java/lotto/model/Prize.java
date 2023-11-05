package lotto.model;

public enum Prize {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 0, true),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000,0),
    FIFTH(3, 5_000,0),
    NONE(0, 0,0);

    private final int match;
    private final int price;
    private int count;
    private final boolean hasBonus;

    Prize(int match, int price, int count) {
        this(match, price, count, false);
    }

    Prize(int match, int price, int count, boolean hasBonus) {
        this.match = match;
        this.price = price;
        this.count = count;
        this.hasBonus = hasBonus;
    }

    public void addCount() {
        count++;
    }

    public int getMatch() {
        return match;
    }

    public int getPrice() {
        return price;
    }

    public boolean isHasBonus() {
        return hasBonus;
    }
}
