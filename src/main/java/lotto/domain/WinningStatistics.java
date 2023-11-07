package lotto.domain;

public class WinningStatistics {
    private int firstPlace;
    private int secondPlace;
    private int thirdPlace;
    private int fourthPlace;
    private int fifthPlace;
    private double winningRate;

    public WinningStatistics() {
        firstPlace = 0;
        secondPlace = 0;
        thirdPlace = 0;
        fourthPlace = 0;
        fifthPlace = 0;
        winningRate = 0;
    }

    public void addFirstPlace() {
        firstPlace++;
    }

    public void addSecondPlace() {
        secondPlace++;
    }

    public void addThirdPlace() {
        thirdPlace++;
    }

    public void addFourthPlace() {
        fourthPlace++;
    }

    public void addFifthPlace() {
        fifthPlace++;
    }

    public void setWinningRate(Double winningRate) {
        this.winningRate = winningRate;
    }

    public double getWinningRate() {
        return winningRate;
    }

    public int getFirstPlace() {
        return firstPlace;
    }

    public int getSecondPlace() {
        return secondPlace;
    }

    public int getThirdPlace() {
        return thirdPlace;
    }

    public int getFourthPlace() {
        return fourthPlace;
    }

    public int getFifthPlace() {
        return fifthPlace;
    }
}
