package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    EMPTY(0, 0, (matchLottoNum, containBonusNum) -> matchLottoNum < 3),
    FIFTH(3, 5000, (matchLottoNum, containBonusNum) -> matchLottoNum == 3),
    FOURTH(4,50000 , (matchLottoNum, containBonusNum) -> matchLottoNum == 4),
    THIRD(5, 1500000, (matchLottoNum, containBonusNum) -> matchLottoNum == 5 && !containBonusNum),
    SECOND(5, 30000000, (matchLottoNum, containBonusNum) -> matchLottoNum == 5 && containBonusNum),
    FIRST(6, 2000000000, (matchLottoNum, containBonusNum) -> matchLottoNum == 6);

    private final int matchLottoCnt;
    private final int money;
    private final BiPredicate<Integer, Boolean> isMatch;

    Rank(final int matchLottoCnt, final int money, final BiPredicate<Integer, Boolean> isMatch) {
        this.matchLottoCnt = matchLottoCnt;
        this.money = money;
        this.isMatch = isMatch;
    }

    public static Rank getRank(final int matchLottoCnt, final boolean containBonusNum) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isMatch.test(matchLottoCnt, containBonusNum))
                .findAny()
                .orElse(EMPTY);
    }

    public int getMatchLottoCnt() {
        return matchLottoCnt;
    }

    public int getMoney() {
        return money;
    }
}
