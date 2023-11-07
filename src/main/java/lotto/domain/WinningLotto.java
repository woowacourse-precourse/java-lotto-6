package lotto.domain;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Integer bonusLotto;

    public WinningLotto(Lotto winningLotto, Integer bonusLotto) {
        this.winningLotto = winningLotto;
        this.bonusLotto = bonusLotto;
    }
}
