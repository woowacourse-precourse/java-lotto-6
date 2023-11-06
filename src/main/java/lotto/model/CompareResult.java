package lotto.model;

public class CompareResult {
    private final int matchCount;
    private final boolean isMatchBonus;

    public CompareResult(int matchCount, boolean isMatchBonus) {
        this.matchCount = matchCount;
        this.isMatchBonus = isMatchBonus;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public boolean isMatchBonus() {
        return isMatchBonus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CompareResult that = (CompareResult) o;

        if (getMatchCount() != that.getMatchCount()) {
            return false;
        }
        return isMatchBonus() == that.isMatchBonus();
    }

    @Override
    public int hashCode() {
        int result = getMatchCount();
        result = 31 * result + (isMatchBonus() ? 1 : 0);
        return result;
    }
}
