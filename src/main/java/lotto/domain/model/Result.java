package lotto.domain.model;

public class Result {
    private final int count;
    private final boolean isIncludeBonus;

    public Result(int count, boolean isIncludeBonus) {
        this.count = count;
        this.isIncludeBonus = isIncludeBonus;
    }

    public int getCount() {
        return count;
    }

    public boolean getIsIncludeBonus() {
        return isIncludeBonus;
    }
}
