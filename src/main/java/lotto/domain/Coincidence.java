package lotto.domain;

public enum Coincidence {
    THREE(5000), FOUR(50000), FIVE(1500000), FIVE_PLUS_BONUS(30000000), SIX(2000000000);
    private final Integer prize;

    Coincidence(Integer prize) {
        this.prize = prize;
    }

    public Integer getPrize() {
        return prize;
    }
}
