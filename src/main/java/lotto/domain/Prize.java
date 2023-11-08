package lotto.domain;

public class Prize{
    private PrizeType prizeType;
    private int compensation;
    private boolean bonusMatch;
    private int count;
    public Prize(){
    }
    public Prize(boolean bonusMatch,int count){
        this.bonusMatch=bonusMatch;
        this.count=count;
    }

    public void setPrizeType(PrizeType prizeType) {
        this.prizeType = prizeType;
    }

    public void setCompensation(int compensation) {
        this.compensation = compensation;
    }

    public PrizeType getPrizeType() {
        return prizeType;
    }

    public int getCompensation() {
        return compensation;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getCount() {
        return count;
    }
}
