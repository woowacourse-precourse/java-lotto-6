package lotto.domain;

public enum LottoCriteria {
    FIRST_PLACE("1", 6, 2000000000),
    SECOND_PLACE("2", 5, 30000000),
    THIRD_PLACE("3", 5, 1500000),
    FOURTH_PLACE("4", 4, 50000),
    FIFTH_PLACE("5", 3, 5000);

    private final String place;
    private final int count;
    private final long amount;

    LottoCriteria(final String place, final int count, final long amount) {
        this.place = place;
        this.count = count;
        this.amount = amount;
    }

    public final String getPlace() {
        return place;
    }

    public final int getCount() {
        return count;
    }

    public final long getAmount() {
        return amount;
    }
}
