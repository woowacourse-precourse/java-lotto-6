package lotto.constants;

import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST((matchedNumbers, bonusWinningNumber) -> matchedNumbers == 6),
    SECOND((matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && bonusWinningNumber),
    THIRD((matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && !bonusWinningNumber),
    FOURTH((matchedNumbers, bonusWinningNumber) -> matchedNumbers == 4),
    FIFTH((matchedNumbers, bonusWinningNumber) -> matchedNumbers == 3),
    NONE((matchedNumbers, bonusWinningNumber) -> matchedNumbers < 3);

    private final BiPredicate<Integer, Boolean> picked;

    LottoRank(BiPredicate<Integer, Boolean> picked) {
        this.picked = picked;
    }

    public static LottoRank evaluateLottoRank(int matchedNumbers, boolean hasBonus) {
        LottoRank lottoRank = null;
        for (LottoRank p : values()) {
            if (p.picked.test(matchedNumbers, hasBonus)) {
                lottoRank = p;
                break;
            }
        }
        return lottoRank;
    }
}
