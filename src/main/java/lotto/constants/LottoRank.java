package lotto.constants;

import java.util.function.BiPredicate;

public enum LottoRank {
    FIRST("2,000,000,000원", (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 6),
    SECOND("30,000,000원", (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && bonusWinningNumber),
    THIRD("1,500,000원", (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && !bonusWinningNumber),
    FOURTH("50,000원", (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 4),
    FIFTH("5,000원", (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 3),
    NONE("", (matchedNumbers, bonusWinningNumber) -> matchedNumbers < 3);

    private final BiPredicate<Integer, Boolean> picked;
    private final String prizeMoney;

    LottoRank(String prizeMoney, BiPredicate<Integer, Boolean> picked) {
        this.prizeMoney = prizeMoney;
        this.picked = picked;
    }

    public static LottoRank evaluateLottoRank(int matchedNumbers, boolean hasBonus) {
        LottoRank lottoRank = NONE;
        for (LottoRank p : values()) {
            if (p.picked.test(matchedNumbers, hasBonus)) {
                lottoRank = p;
                break;
            }
        }
        return lottoRank;
    }
}
