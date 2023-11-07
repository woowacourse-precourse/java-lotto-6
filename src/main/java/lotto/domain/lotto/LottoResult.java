package lotto.domain.lotto;

import java.util.Objects;

public record LottoResult(int matchCount, boolean hasBonusNumber) {

    public static LottoResult of(final int matchCount, final boolean hasBonusNumber) {
        return new LottoResult(matchCount, hasBonusNumber);
    }

    @Override
    public boolean equals(final Object o) {
        if (!(o instanceof LottoResult that)) {
            return false;
        }
        if (this.matchCount != that.matchCount) {
            return false;
        }
        return this.hasBonusNumber == that.hasBonusNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, hasBonusNumber);
    }
}
