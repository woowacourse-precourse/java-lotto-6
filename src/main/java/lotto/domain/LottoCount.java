package lotto.domain;

public class LottoCount {
    private final static int ADD_COUNT = 1;
    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int fiveWithBonusCount;
    private int sixCount;

    public int getThreeCount() {
        return threeCount;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getFiveCount() {
        return fiveCount;
    }

    public int getFiveWithBonusCount() {
        return fiveWithBonusCount;
    }

    public int getSixCount() {
        return sixCount;
    }

    public void addThreeCount() {
        this.threeCount += ADD_COUNT;
    }

    public void addFourCount() {
        this.fourCount += ADD_COUNT;
    }

    public void addFiveCount() {
        this.fiveCount += ADD_COUNT;
    }

    public void addFiveWithBonusCount() {
        this.fiveWithBonusCount += ADD_COUNT;
    }

    public void addSixCount() {
        this.sixCount += ADD_COUNT;
    }
}
