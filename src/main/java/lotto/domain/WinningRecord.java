package lotto.domain;

public class WinningRecord {
    private static int firstPrizeCount = 0;
    private static int secondPrizeCount = 0;
    private static int thirdPrizeCount = 0;
    private static int fourthPrizeCount = 0;
    private static int fifthPrizeCount = 0;


    public void recorder(int count, boolean bonus) {
        if(count == 3) {
            fifthPrizeCount++;
        }
        if(count == 4) {
            fourthPrizeCount++;
        }
        if(count == 5 && !bonus) {
            thirdPrizeCount++;
        }
        if(count == 5 && bonus) {
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
}
