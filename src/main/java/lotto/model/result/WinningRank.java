package lotto.model.result;

import java.util.HashMap;
import java.util.Map;
import lotto.constant.Winning;

public class WinningRank {
    private static Map<Winning, Integer> prizeCount = new HashMap<>();
    private static int firstPrizeCount = 0;
    private static int secondPrizeCount = 0;
    private static int thirdPrizeCount = 0;
    private static int fourthPrizeCount = 0;
    private static int fifthPrizeCount = 0;


    public void recorder(Map<String, Integer> result) {
        int count = result.get("matchedNumberCount");
        int bonus = result.get("isMatchedBonusNumber");
        if(count == 3) {
            fifthPrizeCount++;
        }
        if(count == 4) {
            fourthPrizeCount++;
        }
        if(count == 5 && bonus == 0) {
            thirdPrizeCount++;
        }
        if(count == 5 && bonus == 1) {
            secondPrizeCount++;
        }
        if(count == 6) {
            firstPrizeCount++;
        }
    }

    public int getFirstPrizeCount() {
        return firstPrizeCount;
    }

    public int getSecondPrizeCount() {
        return secondPrizeCount;
    }

    public int getThirdPrizeCount() {
        return thirdPrizeCount;
    }

    public int getFourthPrizeCount() {
        return fourthPrizeCount;
    }

    public int getFifthPrizeCount() {
        return fifthPrizeCount;
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
