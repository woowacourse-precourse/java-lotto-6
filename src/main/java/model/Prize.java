package model;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    NONE(0
            , 0
            , (matchNumberCount, containBonusNumber) -> matchNumberCount < 3),
    FIFTH(5_000
            , 3
            , (matchNumberCount, containBonusNumber) -> matchNumberCount == 3),
    FOURTH(50_000
            , 4
            , (matchNumberCount, containBonusNumber) -> matchNumberCount == 4),
    THIRD(1_500_000
            , 5
            , (matchNumberCount, containBonusNumber) -> matchNumberCount == 5 && !containBonusNumber),
    SECOND(30_000_000
            , 5
            , (matchNumberCount, containBonusNumber) -> matchNumberCount == 5 && containBonusNumber),
    FIRST(2_000_000_000
            , 6
            , (matchNumberCount, containBonusNumber) -> matchNumberCount == 6);

    private final int money;
    private final int matchNumberCount;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int money, final int matchNumberCount, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchNumberCount = matchNumberCount;
        this.isMatch = isMatch;
    }

    public static Prize getPrize(final int matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(NONE);
    }

    public int getMoney() {
        return money;
    }

    public int getMatchNumberCount() {
        return matchNumberCount;
    }
}
