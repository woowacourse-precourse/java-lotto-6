package lotto.domain;

import java.util.function.BiFunction;

public enum Rank {
    FIRST(6, (count, bonus) -> count == 6),
    SECOND(5, (count, bonus) -> count == 5 && bonus),
    THIRD(5, (count, bonus) -> count == 5),
    FOURTH(4, (count, bonus) -> count == 4),
    FIFTH(3,  (count, bonus) -> count == 3),
    NONE(0, (count, bonus) -> count == 0);

    private int count;
    private BiFunction<Integer, Boolean, Boolean> rankMatch;

    Rank(int count, BiFunction<Integer, Boolean, Boolean> rankMatch) {

        this.count = count;
        this.rankMatch = rankMatch;
    }

    public boolean matchRank (int count, boolean bonus) {

        return rankMatch.apply(count, bonus);
    }

}
