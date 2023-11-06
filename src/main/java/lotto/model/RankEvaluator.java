package lotto.model;

import java.util.Iterator;
import lotto.utils.Match;
import lotto.utils.WinningRank;

public class RankEvaluator {
    PrizeNumbers prizeNumbers;

    public RankEvaluator(PrizeNumbers prizeNumbers) {
        this.prizeNumbers = prizeNumbers;
    }

    public WinningRank getRank(Iterator<Integer> lottoIterator) {
        int matchedNumberCount = 0;
        boolean bonusNumberMatched = false;

        while (lottoIterator.hasNext()) {
            int lottoNumber = lottoIterator.next();
            if (prizeNumbers.isMatched(lottoNumber)) {
                matchedNumberCount++;
            }
            if (prizeNumbers.isBonusNumber(lottoNumber)) {
                bonusNumberMatched = true;
            }
        }
        return getRank(matchedNumberCount, bonusNumberMatched);
    }

    private WinningRank getRank(int matchedNumberCount, boolean bonusNumberMatched) {
        if (matchedNumberCount == Match.THREE.getValue()) {
            return WinningRank.FIFTH;
        }
        if (matchedNumberCount == Match.FOUR.getValue()) {
            return WinningRank.FOURTH;
        }
        if (matchedNumberCount == Match.FIVE.getValue()) {
            return getRank(bonusNumberMatched);
        }
        if (matchedNumberCount == Match.SIXTH.getValue()) {
            return WinningRank.FIRST;
        }
        return WinningRank.OUT_OF_RANK;
    }

    private WinningRank getRank(boolean bonusNumberMatched) {
        if (bonusNumberMatched) {
            return WinningRank.SECOND;
        }
        return WinningRank.THIRD;
    }
}
