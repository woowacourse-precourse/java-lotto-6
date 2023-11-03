package lotto.domain;

public enum MatchResult {
    NONE(0),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6);

    private int count;

    MatchResult(int count) {
        this.count = count;
    }

    public static MatchResult fromCount(int count) {
        if (count >= 3 && count <= 6)
            return values()[count];
        else
            return NONE;
    }
}
