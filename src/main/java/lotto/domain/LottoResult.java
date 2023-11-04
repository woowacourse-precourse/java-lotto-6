package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoResult {
    EMPTY(0
            , 0
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3),
    THREE(5_000
            , 3
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
    FOUR(50_000
            , 4
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
    FIVE(1_500_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    FIVEANDBONUS(30_000_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    SIX(2_000_000_000
            , 6
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6);

    private final int money;
    private final int matchLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    LottoResult(final Integer money, final Integer matchLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.matchLottoNumber = matchLottoNumber;
        this.isMatch = isMatch;
    }

    public static LottoResult getLottoResult(final Integer matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(LottoResult.values())
                .filter(lottoResult -> lottoResult.isMatch.test(matchLottoNumber, containBonusNumber))
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
