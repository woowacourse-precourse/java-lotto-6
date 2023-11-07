package lotto.domain;

public class WinningLotto {
    private Lotto winningNumbers;
    private int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        this.winningNumbers = lotto;
        this.bonusNumber = bonusNumber;
    }
}
