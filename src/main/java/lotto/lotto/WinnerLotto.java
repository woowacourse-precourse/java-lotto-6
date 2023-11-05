package lotto.lotto;

public class WinnerLotto {
    private Lotto lotto;
    private int bonusNum;


    public WinnerLotto(Lotto lotto, int bonusNum) {
        this.lotto = lotto;
        this.bonusNum = bonusNum;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNum() {
        return bonusNum;
    }
}
