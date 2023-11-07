package lotto;

public enum Result {
    THREE(5000), FOUR(50000), FIVE(1500000), FIVE_BONUS(30000000), SIX(2000000000), LOSE(0);

    private final int earnings;

    Result(int earnings) {
        this.earnings = earnings;
    }

    public int getEarnings() {
        return earnings;
    }
}
