package lotto.model;

import java.util.List;
import java.util.Objects;

public class LottoPaper {
    private static final int INITIAL_MATCHING_COUNT = 0;
    private int matchingCount;
    private final List<Integer> lottoNumbers;

    LottoPaper(List<Integer> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
        matchingCount = INITIAL_MATCHING_COUNT;
    }

    public boolean hasBonusNumber(int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public void setMatchingCount(int matchingCount) {
        this.matchingCount = matchingCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoPaper that = (LottoPaper) o;
        return matchingCount == that.matchingCount && Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers, matchingCount);
    }
}
