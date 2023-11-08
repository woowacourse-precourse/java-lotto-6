package lotto.domain;

public class WinningNumber {
    private Lotto lotto;

    public WinningNumber(Lotto lotto) {
        this.lotto = lotto;
    }

    public Lotto getWinningLotto() {
        return lotto;
    }
}
