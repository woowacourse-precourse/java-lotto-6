package lotto.domain;

public class LottoResult {
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fiveMatchWithBonusCount;
    private int sixMatchCount;
    private int totalWinningMoney;

    public LottoResult() {
        this.threeMatchCount = 0;
        this.fourMatchCount = 0;
        this.fiveMatchCount = 0;
        this.fiveMatchWithBonusCount = 0;
        this.sixMatchCount = 0;
        this.totalWinningMoney = 0;
    }

    public int getThreeMatchCount() {
        return threeMatchCount;
    }

    public int getFourMatchCount() {
        return fourMatchCount;
    }

    public int getFiveMatchCount() {
        return fiveMatchCount;
    }

    public int getFiveMatchWithBonusCount() {
        return fiveMatchWithBonusCount;
    }

    public int getSixMatchCount() {
        return sixMatchCount;
    }

    public int getTotalWinningMoney() {
        return totalWinningMoney;
    }
}
