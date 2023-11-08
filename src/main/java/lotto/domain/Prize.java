package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum  Prize {
    EMPTY(0, 0, (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3),
    FIFTH(3, 5_000, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
    FOURTH(4, 50_000, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
    THIRD(5, 1_500_000, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    SECOND(5, 30_000_000, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    FIRST(6, 2_000_000_000, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6);

    Prize(int matchLottoNumber, int winningPrize, BiPredicate<Integer, Boolean> isMatch) {
        this.matchLottoNumber = matchLottoNumber;
        this.winningPrize = winningPrize;
        this.isMatch = isMatch;
    }

    private final int matchLottoNumber;
    private final int winningPrize;
    private final BiPredicate<Integer, Boolean> isMatch;

    public static Prize getPrizeResult(int matchLottoNumber, boolean containBonusNumber) {
        return Arrays.stream(Prize.values())
                .filter(prizeResult -> prizeResult.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public int getMatchLottoNumber() {
        return matchLottoNumber;
    }
}
