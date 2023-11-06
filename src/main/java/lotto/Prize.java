package lotto;

public enum Prize {
    FIRST(0, 2000000000L),
    SECOND(1, 30000000L),
    THIRD(2, 1500000L),
    FOURTH(3, 50000L),
    FIFTH(4, 5000L);

    private final int number;
    private final long prizeAmount;

    Prize(int number, long prizeAmount) {
        this.number = number;
        this.prizeAmount = prizeAmount;
    }

    public int getNumber() {
        return number;
    }

    public long getPrizeAmount() {
        return prizeAmount;
    }

    public static long getPrizeAmountByNumber(int number) {
        for (Prize prize : values()) {
            if (prize.number == number) {
                return prize.getPrizeAmount();
            }
        }
        return 0; // 혹은 다른 값을 반환할 수도 있음
    }
}

