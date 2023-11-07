package lotto.core;

public class PortfolioReport {

    private int totalCount;
    private int firstPlaceCount;
    private int secondPlaceCount;
    private int thirdPlaceCount;
    private int fourthPlaceCount;
    private int fifthPlaceCount;
    private double profitRate;

    public PortfolioReport() {
        this.totalCount = 0;
        this.firstPlaceCount = 0;
        this.secondPlaceCount = 0;
        this.thirdPlaceCount = 0;
        this.fourthPlaceCount = 0;
        this.fifthPlaceCount = 0;
        this.profitRate = 0.0;
    }

    public void winFirstPlace() {
        this.firstPlaceCount++;
    }

    public void winSecondPlace() {
        this.secondPlaceCount++;
    }

    public void winThirdPlace() {
        this.thirdPlaceCount++;
    }

    public void winFourthPlace() {
        this.fourthPlaceCount++;
    }

    public void winFifthPlace() {
        this.fifthPlaceCount++;
    }

    public void setProfitRate(double rate) {
        this.profitRate = rate;
    }

    public int getFirstPlaceCount() {
        return firstPlaceCount;
    }

    public int getSecondPlaceCount() {
        return secondPlaceCount;
    }

    public int getThirdPlaceCount() {
        return thirdPlaceCount;
    }

    public int getFourthPlaceCount() {
        return fourthPlaceCount;
    }

    public int getFifthPlaceCount() {
        return fifthPlaceCount;
    }

    public double getProfitRate() {
        return profitRate;
    }
}
