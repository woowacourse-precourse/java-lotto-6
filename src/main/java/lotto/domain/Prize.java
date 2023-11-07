package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    EMPTY(0
            , 0
            , (matchLottoCount, containBonusNumber) -> matchLottoCount < 3),
    FIFTH(5_000,
            3,
            (matchLottoCount, containBonusNumber) -> matchLottoCount == 3),
    FOURTH(50_000,
            4,
            (matchLottoCount, containBonusNumber) -> matchLottoCount == 4),
    THIRD(1_500_000,
            5,
            (matchLottoCount, containBonusNumber) -> matchLottoCount == 5 && !containBonusNumber),
    SECOND(30_000_000,
            5,
            (matchLottoCount, containBonusNumber) -> matchLottoCount == 5 && containBonusNumber),
    FIRST(2_000_000_000,
            6,
            (matchLottoCount, containBonusNumber) -> matchLottoCount == 6);


    private final int money;
    private final int matchLottoCount;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int money, final int matchLottoCount, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchLottoCount = matchLottoCount;
        this.isMatch = isMatch;
    }

    public static Prize getPrize(final int matchLottoCount, final boolean containBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchLottoCount, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }
    public int getMoney() {
        return money;
    }

    public int getMatchLottoCount() {
        return matchLottoCount;
    }
}
