package lotto.LottoPlayer.dto;

public class WinningStatistic {
    private int firstPrizeCount;
    private int secondPrizeCount;
    private int thirdPrizeCount;
    private int fourthPrizeCount;
    private int fifthPrizeCount;

    public WinningStatistic() {
        this.firstPrizeCount = 0;
        this.secondPrizeCount = 0;
        this.thirdPrizeCount = 0;
        this.fourthPrizeCount = 0;
        this.fifthPrizeCount = 0;
    }

    public void increaseFirstPrizeCount() {
        this.firstPrizeCount++;
    }

    public void increaseSecondPrizeCount() {
        this.secondPrizeCount++;
    }

    public void increaseThirdPrizeCount() {
        this.thirdPrizeCount++;
    }

    public void increaseFourthPrizeCount() {
        this.fourthPrizeCount++;
    }

    public void increaseFifthPrizeCount() {
        this.fifthPrizeCount++;
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
