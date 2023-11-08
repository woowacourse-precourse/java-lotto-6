package lotto.model.calculator;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.BonusMatchType;
import lotto.constant.MatchNumber;
import lotto.constant.Winning;

public class WinningRank {
    private static Map<Winning, Integer> prizeCount = new HashMap<>();
    private static int firstPrizeCount = 0;
    private static int secondPrizeCount = 0;
    private static int thirdPrizeCount = 0;
    private static int fourthPrizeCount = 0;
    private static int fifthPrizeCount = 0;

    public void recorderWinningRank(int count, BonusMatchType bonus) {
        if(count == MatchNumber.THREE.getNumber()) {
            fifthPrizeCount++;
        }
        if(count == MatchNumber.FOUR.getNumber()) {
            fourthPrizeCount++;
        }
        if(count == MatchNumber.FIVE.getNumber() && bonus == BonusMatchType.MISMATCH) {
            thirdPrizeCount++;
        }
        if(count == MatchNumber.FIVE.getNumber() && bonus == BonusMatchType.MATCH) {
            secondPrizeCount++;
        }
        if(count == MatchNumber.SIX.getNumber()) {
            firstPrizeCount++;
        }
    }

    public Map<Winning, Integer> getAllPrizeCount() {
        prizeCount.put(Winning.FIRST, firstPrizeCount);
        prizeCount.put(Winning.SECOND, secondPrizeCount);
        prizeCount.put(Winning.THIRD, thirdPrizeCount);
        prizeCount.put(Winning.FOURTH, fourthPrizeCount);
        prizeCount.put(Winning.FIFTH, fifthPrizeCount);
        return prizeCount;
    }
}
