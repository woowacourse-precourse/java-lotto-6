package lotto.domain;

public class SameNumber {
    private int count;
    private boolean hasBonusNumber;

    public SameNumber(int count, boolean hasBonusNumber) {
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
