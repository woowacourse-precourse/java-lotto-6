package lotto.domain;

public class LottoPrize {

    private int threeMatch;
    private int fourMatch;
    private int fiveMatch;
    private int bonusMatch;
    private int allMatch;

    public int getThreeMatch() {
        return threeMatch;
    }

    public int getFourMatch() {
        return fourMatch;
    }

    public int getFiveMatch() {
        return fiveMatch;
    }

    public int getBonusMatch() {
        return bonusMatch;
    }

    public int getAllMatch() {
        return allMatch;
    }

    public void addThreeMatch() {
        this.threeMatch += 1;
    }

    public void addFourMatch() {
        this.fourMatch += 1;
    }

    public void addFiveMatch() {
        this.fiveMatch += 1;
    }

    public void addBonusMatch() {
        this.bonusMatch += 1;
    }

    public void addAllMatch() {
        this.allMatch += 1;
    }
}
