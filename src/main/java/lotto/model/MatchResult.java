package lotto.model;

import java.util.Objects;

public class MatchResult {

    private final int matchCount;
    private final boolean bonusMatch;

    public MatchResult(int matchCount, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.bonusMatch = bonusMatch;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MatchResult that = (MatchResult) o;
        return matchCount == that.matchCount && bonusMatch == that.bonusMatch;
    }

    @Override
    public int hashCode() {
        return Objects.hash(matchCount, bonusMatch);
    }

    @Override
    public String toString() {
        return "MatchResult{" +
            "matchCount=" + matchCount +
            ", bonusMatch=" + bonusMatch +
            '}';
    }
}
