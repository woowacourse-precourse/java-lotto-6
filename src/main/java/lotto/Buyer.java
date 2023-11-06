package lotto;

public class Buyer {
    private Lotto lotto;
    private int bonus;

    private Buyer(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Buyer create(Lotto lotto, int bonus) {
        return new Buyer(lotto, bonus);
    }
}
