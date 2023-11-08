package lotto.domain;

public enum WinningLotto {
    FIND(1, 0),
    THIRD(3, 5000),
    FOURTH(4, 50000),
    FIFTH(5, 1500000),
    FIFTH_WITH_BONUS(7, 30000000),
    SIXTH(6, 2000000000);

    private final int label;
    private final int price;

    WinningLotto(int label, int price) {
        this.label = label;
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public WinningLotto valueOf(int label) {
        for (WinningLotto winning : WinningLotto.values()) {
            if (label == winning.label) {
                return winning;
            }
        }

        return null;
    }
}
