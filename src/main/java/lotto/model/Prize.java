package lotto.model;

public enum Prize {
    FIRST(6, 2_000_000_000, 0),
    SECOND(5, 30_000_000, 0, true),
    THIRD(5, 1_500_000, 0),
    FOURTH(4, 50_000,0),
    FIFTH(3, 5_000,0),
    NONE(0, 0,0);

    Prize(int match, int price, int count) {
        this(match, price, count, false);
    }

    Prize(int match, int price, int count, boolean hasBonus) {
    }

}
