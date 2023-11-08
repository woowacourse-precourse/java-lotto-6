package lotto;

public class WinningResult {
    Lotto lotto;
    int bonusNum;

    public WinningResult(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNum(int bonusNum) {
        this.bonusNum = bonusNum;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
