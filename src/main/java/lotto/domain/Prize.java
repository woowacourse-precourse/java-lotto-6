package lotto.domain;

import java.util.function.BiPredicate;

public enum Prize {
    NOTHING(0
            , 0
            , (matchLottoNumber, matchBonusNumber) -> matchLottoNumber < 3),
    FIFTH(5_000
            , 3
            , (matchLottoNumber, matchBonusNumber) -> matchLottoNumber == 3),
    FOURTH(50_000
            , 4
            , (matchLottoNumber, matchBonusNumber) -> matchLottoNumber == 4),
    THIRD(1_500_000
            , 5
            , (matchLottoNumber, matchBonusNumber) -> matchLottoNumber == 5 && !matchBonusNumber),
    SECOND(30_000_000
            , 5
            , (matchLottoNumber, matchBonusNumber) -> matchLottoNumber == 5 && matchBonusNumber),
    FIRST(2_000_000_000
            , 6
            , (matchLottoNumber, matchBonusNumber) -> matchLottoNumber == 6);

    private final int prizeAmount;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int prizeAmount, final int matchLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.prizeAmount = prizeAmount;
        this.matchLottoNumber = matchLottoNumber;
        this.isMatch = isMatch;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }
}
