package lotto.model;

public class Player {
    private int payment;
    private Lotto lotto;
    private int bonusNumber;

    public Player(int payment, Lotto lotto, int bonusNumber) {
        this.payment = payment;
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getLotto() {
        return lotto;
    }

    public void setLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public void setBonusNumber(int bonusNumber) {
        this.bonusNumber = bonusNumber;
    }
}
