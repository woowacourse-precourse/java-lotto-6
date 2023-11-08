package lotto.result;

public class Result {
    private int checks;
    private boolean isBonus;

    public Result(int checks, boolean isBonus) {
        this.checks = checks;
        this.isBonus = isBonus;
    }

    public int getChecks() {
        return checks;
    }

    public void setChecks(int checks) {
        this.checks = checks;
    }

    public boolean isBonus() {
        return isBonus;
    }

    public void setBonus(boolean bonus) {
        isBonus = bonus;
    }
}
