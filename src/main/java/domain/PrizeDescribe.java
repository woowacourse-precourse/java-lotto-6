package domain;

public class PrizeDescribe {
    private static PrizeDescribe instance;
    private int fifthPrize = 0;
    private int fourthPrize = 0;
    private int thirdPrize = 0;
    private int secondPrize = 0;
    private int firstPrize = 0;

    private PrizeDescribe() {}

    public static PrizeDescribe getInstance() {
        if (instance == null) {
            instance = new PrizeDescribe();
        }
        return instance;
    }

    public void winFifthPrize() {
        this.fifthPrize += 1;
    }
    public void winFourthPrize() {
        this.fourthPrize += 1;
    }
    public void winThirdPrize() {
        this.thirdPrize += 1;
    }
    public void winSecondPrize() {
        this.secondPrize += 1;
    }
    public void winFirstPrize() {
        this.firstPrize += 1;
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
