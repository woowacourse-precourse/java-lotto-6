package lotto.domain;

public class LottoResult {
    
    private int threeCount = 0;
    
    private int fourCount = 0;

    private int fiveCount = 0;
    
    private int fiveBonusCount = 0;
    
    private int sixCount = 0;

    public void addThreeCount() {
        threeCount++;
    }

    public void addFourCount() {
        fourCount++;
    }

    public void addFiveCount() {
        fiveCount++;
    }

    public void addFiveBonusCount() {
        fiveBonusCount++;
    }

    public void addSixCount() {
        sixCount++;
    }

    public int getThreeCount() {
        return threeCount;
    }

    public int getFourCount() {
        return fourCount;
    }

    public int getFiveCount() {
        return fiveCount;
    }

    public int getFiveBonusCount() {
        return fiveBonusCount;
    }

    public int getSixCount() {
        return sixCount;
    }
}
