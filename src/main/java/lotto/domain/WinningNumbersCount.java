package lotto.domain;

public class WinningNumbersCount {
    private final int count;
    private final boolean hasBonusNumber;

    public WinningNumbersCount(int count, boolean hasBonusNumber) {
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
