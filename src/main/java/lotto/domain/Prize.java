package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Prize {
    NOTHING(0
            , 0
            , (matchLottoNumbers, matchBonusNumber) -> matchLottoNumbers < 3),
    FIFTH(5_000
            , 3
            , (matchLottoNumbers, matchBonusNumber) -> matchLottoNumbers == 3),
    FOURTH(50_000
            , 4
            , (matchLottoNumbers, matchBonusNumber) -> matchLottoNumbers == 4),
    THIRD(1_500_000
            , 5
            , (matchLottoNumbers, matchBonusNumber) -> matchLottoNumbers == 5 && !matchBonusNumber),
    SECOND(30_000_000
            , 5
            , (matchLottoNumbers, matchBonusNumber) -> matchLottoNumbers == 5 && matchBonusNumber),
    FIRST(2_000_000_000
            , 6
            , (matchLottoNumbers, matchBonusNumber) -> matchLottoNumbers == 6);

    private final int prizeAmount;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    Prize(final int prizeAmount, final int matchLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.prizeAmount = prizeAmount;
        this.matchLottoNumber = matchLottoNumber;
        this.isMatch = isMatch;
    }

    public static Prize getPrize(final int matchLottoNumbers, final boolean matchBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prize -> prize.isMatch.test(matchLottoNumbers, matchBonusNumber))
                .findAny()
                .orElse(NOTHING);
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }
}
