package lotto;

import java.util.Arrays;

public enum MatchCount {
    FIRST(0, 6, false),
    SECOND(1, 5, true),
    THIRD(2, 5, false),
    FORTH(3, 4, false),
    FIFTH(4, 3, false),
    EMPTY(5, 0, false);


    private final int index;
    private final int count;
    private final boolean bonus;

    MatchCount(int index, int count, boolean bonus) {
        this.index = index;
        this.count = count;
        this.bonus = bonus;
    }

    public static MatchCount getMatchCount(int count, boolean bonus) {
        return Arrays.stream(MatchCount.values()).filter(x -> x.count == count && x.bonus == bonus).findAny().orElse(EMPTY);

    }

    public static int getMatchIndex(int count, boolean bonus) {
        return getMatchCount(count, bonus).getIndex();
    }

    public int getIndex() {
        return this.index;
    }
}
