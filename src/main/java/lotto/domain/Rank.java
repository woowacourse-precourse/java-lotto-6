package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, 2000000000, (matchLottoNum, containBonusNum) -> matchLottoNum == 6),
    SECOND(5, 30000000, (matchLottoNum, containBonusNum) -> matchLottoNum == 5 && containBonusNum),
    THIRD(5, 1500000, (matchLottoNum, containBonusNum) -> matchLottoNum == 5 && !containBonusNum),
    FOURTH(4,50000 , (matchLottoNum, containBonusNum) -> matchLottoNum == 4),
    FIFTH(3, 5000, (matchLottoNum, containBonusNum) -> matchLottoNum == 3),
    EMPTY(0, 0, (matchLottoNum, containBonusNum) -> matchLottoNum < 3);
    private final int matchLottoCnt;
    private final int money;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(final int matchLottoCnt, final int money, final BiPredicate<Integer, Boolean> isMatch) {
        this.matchLottoCnt = matchLottoCnt;
        this.money = money;
        this.isMatch = isMatch;
    }

    public static Rank getRank(final int matchLottoCnt, final boolean cotainBonusNum) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch.test(matchLottoCnt, cotainBonusNum))
                .findAny()
                .orElse(EMPTY);
    }
}
