package lotto.domain;

import java.util.Objects;

public class LottoScore {
    private int sameCount;
    private boolean isBonusContains;

    public LottoScore(int sameCount, boolean isBonusContains) {
        this.sameCount = sameCount;
        this.isBonusContains = isBonusContains;
    }

    public Winner getWinners() {
        return Winner.of(sameCount, isBonusContains);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoScore that = (LottoScore) o;
        return sameCount == that.sameCount && isBonusContains == that.isBonusContains;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sameCount, isBonusContains);
    }
}
