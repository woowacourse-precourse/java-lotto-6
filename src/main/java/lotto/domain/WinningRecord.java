package lotto.domain;

import java.util.Arrays;
import java.util.List;

public class WinningRecord {
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

    public List<Integer> getAllPrizeCount() {
        return Arrays.asList(firstPrizeCount, secondPrizeCount, thirdPrizeCount, fourthPrizeCount, fifthPrizeCount);
    }
}
