package model;

public class PrizeStatistics {
    private static final int ADD_PRIZE = 1;
    private static PrizeStatistics instance;
    private int fifthPrize = 0, fourthPrize = 0, thirdPrize = 0, secondPrize = 0, firstPrize = 0;

    private PrizeStatistics() {
    }

    public static PrizeStatistics getInstance() {
        if (instance == null) {
            instance = new PrizeStatistics();
        }
        return instance;
    }

    public void winFifthPrize() {
        this.fifthPrize += ADD_PRIZE;
    }

    public void winFourthPrize() {
        this.fourthPrize += ADD_PRIZE;
    }

    public void winThirdPrize() {
        this.thirdPrize += ADD_PRIZE;
    }

    public void winSecondPrize() {
        this.secondPrize += ADD_PRIZE;
    }

    public void winFirstPrize() {
        this.firstPrize += ADD_PRIZE;
    }

    public int getFifthPrize() {
        return fifthPrize;
    }

    public int getFourthPrize() {
        return fourthPrize;
    }

    public int getThirdPrize() {
        return thirdPrize;
    }

    public int getSecondPrize() {
        return secondPrize;
    }

    public int getFirstPrize() {
        return firstPrize;
    }

}
