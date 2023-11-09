package lotto.constant;

public enum LottoRanking {

    NONE(0, false, 0),
    FIFTH(3, false, 5_000),
    FOURTH(4, false, 50_000),
    THIRD(5, false, 1_500_000),
    SECOND(5, true, 30_000_000),
    FIRST(6, false, 2_000_000_000);

    private final int hit;
    private final boolean bonus;
    private final int price;

    LottoRanking(int hit, boolean bonus, int price) {
        this.hit = hit;
        this.bonus = bonus;
        this.price = price;
    }

    public static LottoRanking of(int hit, boolean bonus) {
        if (hit == 6) return FIRST;
        if (hit == 5 && bonus) return SECOND;
        if (hit == 5) return THIRD;
        if (hit == 4) return FOURTH;
        if (hit == 3) return FIFTH;
        return NONE;
    }

    public int getHit() {
        return hit;
    }

    public boolean isBonus() {
        return bonus;
    }

    public int getPrice() {
        return price;
    }
}
