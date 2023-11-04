package lotto;

import java.util.function.BiFunction;

public enum WinningLotto {

    FIRST_PLACE(6, 0, 2000000000, (matchCount, bonusCount) -> matchCount == 6),
    SECOND_PLACE(5, 1, 30000000, (matchCount, bonusCount) -> matchCount == 5 && bonusCount == 1),
    THIRD_PLACE(5, 0, 1500000, (matchCount, bonusCount) -> matchCount == 5 && bonusCount == 0),
    FOURTH_PLACE(4, 0, 50000, (matchCount, bonusCount) -> matchCount == 4),
    FIFTH_PLACE(3, 0, 5000, (matchCount, bonusCount) -> matchCount == 3),
    LAST_PLACE(2, 0, 0, (matchCount, bonusCount) -> matchCount <= 2),
    ;

    private final int matchCount;
    private final int bonusCount;
    private final long price;
    private final BiFunction<Integer, Integer, Boolean> function;

    WinningLotto(int matchCount, int bonusCount, long price, BiFunction<Integer, Integer, Boolean> function) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.price = price;
        this.function = function;
    }

    public boolean getLottoRank(final int matchCount, final int bonusCount) {
        return function.apply(matchCount, bonusCount);
    }

    public long getPrice() {
        return price;
    }
}
