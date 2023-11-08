package lotto.domain;

public class WinnigNumber {
    private final Lotto lotto;
    private final int bonus;

    WinnigNumber(final Lotto lotto, final int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static WinnigNumber is(final Lotto lotto, final int bonus) {
        return new WinnigNumber(lotto, bonus);
    }

    public boolean contains(int number) {
        return lotto.contains(number);
    }

    public int getBonus() {
        return bonus;
    }
}
