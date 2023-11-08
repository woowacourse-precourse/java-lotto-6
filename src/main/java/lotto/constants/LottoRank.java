package lotto.constants;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum LottoRank {
    NONE(0, (matchedNumbers, bonusWinningNumber) -> matchedNumbers < 3, ""),
    FIFTH(5000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 3,
            "3개 일치 (5,000원)"),
    FOURTH(50000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 4,
            "4개 일치 (50,000원)"),
    THIRD(1500000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && !bonusWinningNumber,
            "5개 일치 (1,500,000원)"),
    SECOND(30000000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 5 && bonusWinningNumber,
            "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(2000000000, (matchedNumbers, bonusWinningNumber) -> matchedNumbers == 6,
            "6개 일치 (2,000,000,000원)");

    private final BiPredicate<Integer, Boolean> picked;
    private final int prizeMoney;
    private final String description;

    LottoRank(int prizeMoney, BiPredicate<Integer, Boolean> picked, String description) {
        this.prizeMoney = prizeMoney;
        this.picked = picked;
        this.description = description;
    }

    public static LottoRank evaluateLottoRank(int matchedNumbers, boolean hasBonus) {
        return Arrays.stream(values())
                .filter(p -> p.picked.test(matchedNumbers, hasBonus))
                .findFirst()
                .orElse(NONE);
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
    }
