package lotto.domain.result;

import java.util.HashMap;
import java.util.Map;

public class WonRecord {
    private static Map<String, Integer> prizeCount = new HashMap<>();
    private static int firstPrizeCount = 0;
    private static int secondPrizeCount = 0;
    private static int thirdPrizeCount = 0;
    private static int fourthPrizeCount = 0;
    private static int fifthPrizeCount = 0;


    public void recorder(int count, int bonus) {
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

    public Map<String, Integer> getAllPrizeCount() {
        prizeCount.put("first", firstPrizeCount);
        prizeCount.put("second", secondPrizeCount);
        prizeCount.put("third", thirdPrizeCount);
        prizeCount.put("fourth", fourthPrizeCount);
        prizeCount.put("fifth", fifthPrizeCount);
        return prizeCount;
    }
}
