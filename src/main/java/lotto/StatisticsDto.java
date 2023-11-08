package lotto;

public class StatisticsDto {
    private int firstPlaceLottoCount;
    private int secondPlaceLottoCount;
    private int thirdPlaceLottoCount;
    private int fourthPlaceLottoCount;
    private int fifthPlaceLottoCount;
    private double profitRatio;

    public StatisticsDto(int firstPlaceLottoCount, int secondPlaceLottoCount, int thirdPlaceLottoCount,
                         int fourthPlaceLottoCount, int fifthPlaceLottoCount, double profitRatio) {
        this.firstPlaceLottoCount = firstPlaceLottoCount;
        this.secondPlaceLottoCount = secondPlaceLottoCount;
        this.thirdPlaceLottoCount = thirdPlaceLottoCount;
        this.fourthPlaceLottoCount = fourthPlaceLottoCount;
        this.fifthPlaceLottoCount = fifthPlaceLottoCount;
        this.profitRatio = profitRatio;
    }

    public int getFirstPlaceLottoCount() {
        return firstPlaceLottoCount;
    }

    public int getSecondPlaceLottoCount() {
        return secondPlaceLottoCount;
    }

    public int getThirdPlaceLottoCount() {
        return thirdPlaceLottoCount;
    }

    public int getFourthPlaceLottoCount() {
        return fourthPlaceLottoCount;
    }

    public int getFifthPlaceLottoCount() {
        return fifthPlaceLottoCount;
    }

    public double getProfitRatio() {
        return profitRatio;
    }
}
