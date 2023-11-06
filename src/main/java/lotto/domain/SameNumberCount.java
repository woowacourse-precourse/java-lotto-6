package lotto.domain;

public class SameNumberCount {
    private int count;
    private boolean hasBonusNumber;

    public SameNumberCount(int count, boolean hasBonusNumber) {
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
