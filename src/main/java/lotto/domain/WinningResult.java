package lotto.domain;

public class WinningResult {
    private long threeMatches;
    private long fourMatches;
    private long fiveMatches;
    private long fiveAndBonusMatches;
    private long sixMatches;
    private double totalReturn;

    public long getThreeMatches() {
        return threeMatches;
    }

    public void addThreeMatches() {
        this.threeMatches++;
    }

    public long getFourMatches() {
        return fourMatches;
    }

    public void addFourMatches() {
        this.fourMatches++;
    }

    public long getFiveMatches() {
        return fiveMatches;
    }

    public void addFiveMatches() {
        this.fiveMatches++;
    }

    public long getFiveAndBonusMatches() {
        return fiveAndBonusMatches;
    }

    public void addFiveAndBonusMatches() {
        this.fiveAndBonusMatches++;
    }

    public long getSixMatches() {
        return sixMatches;
    }

    public void addSixMatches() {
        this.sixMatches++;
    }

    public double getTotalReturn() {
        return totalReturn;
    }

    public void calculateTotalReturn(int purchaseAmount) {
        double totalWinningAmount =
                threeMatches * 5000
                        + fourMatches * 50000
                        + fiveMatches * 1500000
                        + fiveAndBonusMatches * 30000000
                        + sixMatches * 2000000000;

        this.totalReturn = roundNumber((totalWinningAmount / purchaseAmount) * 100.0);
    }

    private double roundNumber(double number) {
        return Math.round(number * 10) / 10.0;
    }
}
