package domain;

public class LottoMatchCount {
    private int threeCount;
    private int fourCount;
    private int fiveCount;
    private int fiveWithBonusCount;
    private int sixCount;

    public int getThreeCount(){
        return threeCount;
    }
    public int getFourCount(){
        return fourCount;
    }
    public int getFiveCount(){
        return fiveCount;
    }
    public int getFiveWithBonusCount(){
        return fiveWithBonusCount;
    }
    public int getSixCount(){
        return sixCount;
    }

    public void addThreeCount(){
        this.threeCount++;
    }
    public void addFourCount(){
        this.fourCount++;
    }
    public void addFiveCount(){
        this.fiveCount++;
    }
    public void addFiveWithBonusCount(){
        this.fiveWithBonusCount++;
    }
    public void addSixCount(){
        this.sixCount++;
    }
}
