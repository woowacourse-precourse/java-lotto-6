package lotto.domain;

public class Winning {

    private Lotto lotto;
    private int Bonus;

    public Winning(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.Bonus = bonus;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonus() {
        return Bonus;
    }
}
