package lotto.message;

public enum FlagInput {
    FLAG_AMOUNT_BEFORE(true),
    FLAG_AMOUNT_AFTER(false),
    FLAG_PRIZE_BEFORE(true),
    FLAG_PRIZE_AFTER(false),
    FLAG_BONUS_BEFORE(true),
    FLAG_BONUS_AFTER(false);

    private boolean flag;

    FlagInput(boolean flag) {
        this.flag = flag;
    }

    public boolean getMessage() {
        return flag;
    }
}
