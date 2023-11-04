package lotto.domain;

public class LottoCount {
    private final static int addCount = 1;
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
        this.threeCount += addCount;
    }
    public void addFourCount() {
        this.fourCount += addCount;
    }
    public void addFiveCount() {
        this.fiveCount += addCount;
    }
    public void addFiveWithBonusCount() {
        this.fiveWithBonusCount += addCount;
    }
    public void addSixCount() {
        this.sixCount += addCount;
    }
}
