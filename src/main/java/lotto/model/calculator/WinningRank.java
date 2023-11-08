package lotto.model.calculator;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.BonusMatchType;
import lotto.constant.UnitNumber;
import lotto.constant.Winning;

public class WinningRank {
    private static final Map<Winning, Integer> prizeCount = new HashMap<>();

    public WinningRank() {
        initializePrizeCount();
    }

    public void initializePrizeCount() {
        for(Winning winning : Winning.values()) {
            prizeCount.put(winning, UnitNumber.ZERO.getNumber());
        }
    }

    public void recordWinningRank(int count, BonusMatchType bonus) {
        recordRank(count, Winning.FIFTH);
        recordRank(count, Winning.FOURTH);
        recordRankThird(count, Winning.THIRD, bonus);
        recordRankSecond(count, Winning.SECOND, bonus);
        recordRank(count, Winning.FIRST);
    }

    public void recordRank(int count, Winning winning) {
        int currentCount = prizeCount.get(winning);
        if(count == winning.getMatchNumber()) {
            prizeCount.put(winning, currentCount + UnitNumber.RANK_PLUS.getNumber());
        }
    }

    public void recordRankThird(int count, Winning winning, BonusMatchType bonus) {
        int currentCount = prizeCount.get(winning);
        if(count == winning.getMatchNumber() && bonus == BonusMatchType.MISMATCH) {
            prizeCount.put(winning, currentCount + UnitNumber.RANK_PLUS.getNumber());
        }
    }

    public void recordRankSecond(int count, Winning winning, BonusMatchType bonus) {
        int currentCount = prizeCount.get(winning);
        if(count == winning.getMatchNumber() && bonus == BonusMatchType.MATCH) {
            prizeCount.put(winning, currentCount + UnitNumber.RANK_PLUS.getNumber());
        }
    }

    public Map<Winning, Integer> getAllPrizeCount() {
        return prizeCount;
    }
}
