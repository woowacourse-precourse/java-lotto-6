package lotto.domain;

import static lotto.domain.constant.DomainConstant.ZERO;

import java.util.EnumMap;
import java.util.Map;
import lotto.domain.money.Money;

public enum LottoPrizes {
    THREE_NUMBERS_MATCHED("3개 일치", new Money(5_000L)),
    FOUR_NUMBERS_MATCHED("4개 일치", new Money(50_000L)),
    FIVE_NUMBER_MATCHED("5개 일치", new Money(1_500_000L)),
    FIVE_NUMBER_AND_BONUS_MATCHED("5개 일치, 보너스 볼 일치", new Money(30_000_000L)),
    SIX_NUMBER_MATCHED("6개 일치", new Money(2_000_000_000L));

    private final String term;
    private final Money winningAmount;

    LottoPrizes(String term, Money winningAmount) {
        this.term = term;
        this.winningAmount = winningAmount;
    }

    public String getTerm() {
        return term;
    }

    public Money getWinningAmount() {
        return winningAmount;
    }

    public String winningAmountToString() {
        return winningAmount.toString();
    }

    public static Map<LottoPrizes, Long> getPrizesCountMap() {
        Map<LottoPrizes, Long> prizesCountsMap = new EnumMap<>(LottoPrizes.class);
        for (LottoPrizes lottoPrizes : LottoPrizes.values()) {
            prizesCountsMap.put(lottoPrizes, ZERO);
        }
        return prizesCountsMap;
    }
}
