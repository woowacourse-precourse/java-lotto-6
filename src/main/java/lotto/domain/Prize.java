package lotto.domain;

public class Prize{
    private PrizeType prizeType;
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

    public PrizeType getPrizeType() {
        return prizeType;
    }

    public boolean isBonusMatch() {
        return bonusMatch;
    }

    public int getCount() {
        return count;
    }
}
