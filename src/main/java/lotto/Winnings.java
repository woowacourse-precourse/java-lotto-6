package lotto;

public enum Winnings {
    FIRST_PLACE_PRIZE(2000000000L),
    SECOND_PLACE_PRIZE(30000000L),
    THIRD_PLACE_PRIZE(1500000L),
    FOURTH_PLACE_PRIZE(50000L),
    FIFTH_PLACE_PRIZE(5000L);

    private final Long prize;

    private Winnings(Long rank) {
        this.prize = rank;
    }

    public Long getPrize() {
        return prize;
    }
}
