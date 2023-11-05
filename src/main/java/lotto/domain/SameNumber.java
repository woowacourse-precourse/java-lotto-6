package lotto.domain;

import lotto.constants.Rank;

public class SameNumber {
    private int count;
    private boolean hasBonusNumber;

    public SameNumber(int count, boolean hasBonusNumber) {
        this.count = count;
        this.hasBonusNumber = hasBonusNumber;
    }

    public Rank createRank() {
        if (count == 6) {
            return Rank.FIRST;
        }
        if (count == 5 && hasBonusNumber) {
            return Rank.SECOND;
        }
        if (count == 5 && !hasBonusNumber) {
            return Rank.THIRD;
        }
        if (count == 4) {
            return Rank.FOURTH;
        }
        if (count == 3) {
            return Rank.FIFTH;
        }
        return null;
    }

    public int getCount() {
        return count;
    }

    public boolean hasBonusNumber() {
        return hasBonusNumber;
    }
}
