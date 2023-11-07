package lotto.domain;

public class WinningLotto {

    private Lotto lotto;
    private int bonusNumber;
    private static WinningLotto winningLotto;

    private WinningLotto() {
    }

    public static WinningLotto getInstance() {
        if (winningLotto == null) {
            winningLotto = new WinningLotto();
            return winningLotto;
        }
        return winningLotto;
    }


    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
