package lotto.domain;

public class WinningLotto extends Lotto {
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        super(lotto.getNumbers());
        this.bonusNumber = bonusNumber;
    }
}
