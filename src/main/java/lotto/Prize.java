package lotto;
// Prize.java  파일
public enum Prize {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    NONE(0);

    private final int prizeAmount;

    Prize(int prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public static Prize calculatePrize(int matchedNumbers, boolean hasBonusNumber) {
        if (matchedNumbers == 6) return Prize.FIRST;
        if (matchedNumbers == 5 && hasBonusNumber) return Prize.SECOND;
        if (matchedNumbers == 5) return Prize.THIRD;
        if (matchedNumbers == 4) return Prize.FOURTH;
        if (matchedNumbers == 3) return Prize.FIFTH;
        return Prize.NONE;
    }
}
