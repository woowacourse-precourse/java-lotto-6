package lotto.domain;

import java.util.Arrays;
import java.util.List;

public enum LottoPrize {
    PRIZE_1ST(6, new Money(2_000_000_000)),
    PRIZE_2ND(5, new Money(30_000_000)),
    PRIZE_3RD(5, new Money(1_500_000)),
    PRIZE_4TH(4, new Money(50_000)),
    PRIZE_5TH(3, new Money(5_000)),
    NOTHING(0, new Money(0));
    private final int matchingCount;
    private final Money prize;

    LottoPrize(int matchingCount, Money prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public int getMatchingCount() {
        return matchingCount;
    }

    public Money getPrize() {
        return prize;
    }

    public static LottoPrize determinePrize(int matchingCount) {
        return Arrays.stream(values())
                .filter(prize -> prize.getMatchingCount() == matchingCount)
                .findFirst()
                .orElse(NOTHING);
    }

    public static LottoPrize determine2ndOr3rdPrize(List<Integer> lottoNumbers, int bonusNumber) {
        if (lottoNumbers.contains(bonusNumber)) {
            return PRIZE_2ND;
        }
        return PRIZE_3RD;
    }
}