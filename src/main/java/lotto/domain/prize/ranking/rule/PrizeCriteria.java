package lotto.domain.prize.ranking.rule;

import lotto.domain.prize.ranking.PrizeMatchingNumber;

public enum PrizeCriteria {

    FIRST((lotto, prize) -> prize.isWin(lotto, PrizeMatchingNumber.FIRST.getMatchCount())),
    SECOND((lotto, prize) -> prize.isWinWithBonus(lotto, PrizeMatchingNumber.SECOND.getMatchCount())),
    THIRD((lotto, prize) -> prize.isWinWithoutBonus(lotto, PrizeMatchingNumber.THIRD.getMatchCount())),
    FOURTH((lotto, prize) -> prize.isWin(lotto, PrizeMatchingNumber.FOURTH.getMatchCount())),
    FIFTH((lotto, prize) -> prize.isWin(lotto, PrizeMatchingNumber.FIFTH.getMatchCount()));

    private final PrizeRule prizeRule;

    PrizeCriteria(final PrizeRule prizeRule) {
        this.prizeRule = prizeRule;
    }

    public PrizeRule getPrizeRule() {
        return prizeRule;
    }
}
