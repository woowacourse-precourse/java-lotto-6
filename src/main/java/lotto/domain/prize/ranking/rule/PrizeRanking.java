package lotto.domain.prize.ranking.rule;

import lotto.domain.prize.ranking.PrizeAmount;

public enum PrizeRanking {
    FIRST(PrizeCriteria.FIRST, PrizeAmount.FIRST),
    SECOND(PrizeCriteria.SECOND, PrizeAmount.SECOND),
    THIRD(PrizeCriteria.THIRD, PrizeAmount.THIRD),
    FOURTH(PrizeCriteria.FOURTH, PrizeAmount.FOURTH),
    FIFTH(PrizeCriteria.FIFTH, PrizeAmount.FIFTH);

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
