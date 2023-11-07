package lotto.model;

public class Result {
    private int match;
    private boolean bonus;

    public Result(int match, boolean bonus) {
        this.match = match;
        this.bonus = bonus;
    }

    public int getMatch() {
        return match;
    }

    public boolean isBonus() {
        return bonus;
    }
}
