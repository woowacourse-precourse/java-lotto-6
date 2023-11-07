package lotto.domain;

public enum Prize {
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    BONUS(7, 30000000),
    SIX(6, 2000000000);

    private final int correcting;
    private final int price;

    Prize(int correcting, int price) {
        this.correcting = correcting;
        this.price = price;
    }

    public Prize getCorrectPrize(int correcting) {
        for (Prize prize : Prize.values()) {
            if (isCorrectingPrize(prize, correcting)) {
                return prize;
            }
        }
        return null;
    }

    public int getCorrecting() {
        return correcting;
    }

    public int getPrice() {
        return price;
    }

    public boolean isCorrectingPrize(Prize prize, int correcting) {
        return correcting == prize.correcting;
    }
}
