package lotto.domain;

public class LottoResult {
    private int threeMatchCount;
    private int fourMatchCount;
    private int fiveMatchCount;
    private int fiveMatchWithBonusCount;
    private int sixMatchCount;

    public LottoResult() {
        this.threeMatchCount = 0;
        this.fourMatchCount = 0;
        this.fiveMatchCount = 0;
        this.fiveMatchWithBonusCount = 0;
        this.sixMatchCount = 0;
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


    public void addMatchingCount(int matchCount, boolean isBonusNumberMatching) {
        if (matchCount == 3) {
            threeMatchCount++;
        } else if (matchCount == 4) {
            fourMatchCount++;
        } else if (matchCount == 5 && !isBonusNumberMatching) {
            fiveMatchCount++;
        } else if (matchCount == 5 && isBonusNumberMatching) {
            fiveMatchWithBonusCount++;
        } else if (matchCount == 6) {
            sixMatchCount++;
        }
    }

    public double calculateProfitRate(double money) {
        double totalProfit = threeMatchCount * 5000 + fourMatchCount * 50000
                + fiveMatchCount * 1500000 + fiveMatchWithBonusCount * 30000000
                + sixMatchCount * 2000000000;

        double profitRate = (totalProfit / money) * 100.0;

        return Math.round(profitRate * 10.0) / 10.0;
    }
}
