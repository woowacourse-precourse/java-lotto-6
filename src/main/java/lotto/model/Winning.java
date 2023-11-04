package lotto.model;

public class Winning {
    private Lotto result;
    private int bonus;

    public Winning(Lotto result, int bonus) {
        this.result = result;
        this.bonus = bonus;
    }

    public Lotto getResult() {
        return result;
    }

    public int getBonus() {
        return bonus;
    }
}
