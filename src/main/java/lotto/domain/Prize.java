package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    EMPTY(0
           , 0
           , (matchLottoNumber, containBounsNumber) -> matchLottoNumber < 3),
    FIFTH(5_000
        , 0
        , (matchLottoNumber, containBounsNumber) -> matchLottoNumber == 3),
    FOURTH(50_000
            , 4
            , (matchLottoNumber, containBounsNumber) -> matchLottoNumber == 4),
    THIRD(1_500_000
            , 5
            , (matchLottoNumber, containBounsNumber) -> matchLottoNumber == 5 && !containBounsNumber),
    SECOND(30_000_000
            , 5
            , (matchLottoNumber, containBounsNumber) -> matchLottoNumber == 5 && containBounsNumber),
    FIRST(2_000_000_000
            , 0
            , (matchLottoNumber, containBounsNumber) -> matchLottoNumber == 6);

    private final int money;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int money, final int matchLottoNumber, final BiPredicate isMatch) {
        this.money = money;
        this.matchLottoNumber = matchLottoNumber;
        this.isMatch = isMatch;
    }

    public static Prize getPrize(final int matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getMoney() {
        return money;
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }
}
