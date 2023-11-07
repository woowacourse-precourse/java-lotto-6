package lotto;

public class Result {
    private int sameNumber;
    private boolean bonusNum;

    public void addNum() {
        sameNumber++;
    }

    public int getSameNumber() {
        return sameNumber;
    }

    public void setSameNumber(int sameNumber) {
        this.sameNumber = sameNumber;
    }

    public boolean isBonusNum() {
        return bonusNum;
    }

    public void setBonusNum(boolean bonusNum) {
        this.bonusNum = bonusNum;
    }
}
