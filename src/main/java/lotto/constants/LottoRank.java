package lotto.constants;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST(2000000000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 6),
    SECOND(30000000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && bonusWinningNumber),
    THIRD(1500000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && !bonusWinningNumber),
    FOURTH(50000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 4),
    FIFTH(5000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 3),
    NONE(0, (matchedNumbers, bonusWinningNumber) -> matchedNumbers < 3);

    private final BiPredicate<Integer, Boolean> picked;
    private final int prizeMoney;

    LottoRank(int prizeMoney, BiPredicate<Integer, Boolean> picked) {
        this.prizeMoney = prizeMoney;
        this.picked = picked;
    }

    public static LottoRank evaluateLottoRank(int matchedNumbers, boolean hasBonus) {
        LottoRank lottoRank = Arrays.stream(values())
                .filter(p -> p.picked.test(matchedNumbers, hasBonus))
                .findFirst()
                .orElse(NONE);
        return lottoRank;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
