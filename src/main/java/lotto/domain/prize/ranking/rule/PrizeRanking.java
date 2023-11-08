package lotto.domain.prize.ranking.rule;

import lotto.domain.prize.ranking.PrizeAmount;

public enum PrizeRanking {
    FIFTH(PrizeCriteria.FIFTH, PrizeAmount.FIFTH),
    FOURTH(PrizeCriteria.FOURTH, PrizeAmount.FOURTH),
    THIRD(PrizeCriteria.THIRD, PrizeAmount.THIRD),
    SECOND(PrizeCriteria.SECOND, PrizeAmount.SECOND),
    FIRST(PrizeCriteria.FIRST, PrizeAmount.FIRST);

    private final PrizeCriteria prizeCriteria;
    private final PrizeAmount prizeAmount;

    PrizeRanking(
            final PrizeCriteria prizeCriteria,
            final PrizeAmount prizeAmount
    ) {
        this.prizeCriteria = prizeCriteria;
        this.prizeAmount = prizeAmount;
    }

    public PrizeCriteria getPrizeCriteria() {
        return prizeCriteria;
    }

    public PrizeAmount getPrizeAmount() {
        return prizeAmount;
    }
}
