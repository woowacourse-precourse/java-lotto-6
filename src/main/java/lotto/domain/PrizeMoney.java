package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum PrizeMoney {
    EMPTY(0
            , 0
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3),
    FIFTH(5_000
            , 3
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
    FOURTH(50_000
            , 4
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
    THIRD(1_500_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
    SECOND(30_000_000
            , 5
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
    FIRST(2_000_000_000
            , 6
            , (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6);

    private final int money;
    private final int rightLottoNumber;
    private final BiPredicate<Integer, Boolean> isMatch;

    PrizeMoney(final int money, final int rightLottoNumber, final BiPredicate<Integer, Boolean> isMatch) {
        this.money = money;
        this.rightLottoNumber = rightLottoNumber;
        this.isMatch = isMatch;
    }

    public static PrizeMoney getPrizeMoney(final int matchLottoNumber, final boolean containBonusNumber) {
        return Arrays.stream(PrizeMoney.values())
                .filter(prizeMoney -> prizeMoney.isMatch.test(matchLottoNumber, containBonusNumber))
                .findAny()
                .orElse(EMPTY);
    }

    public int getMoney() {
        return money;
    }

    public int getRightLottoNumber() {
        return rightLottoNumber;
    }
}
