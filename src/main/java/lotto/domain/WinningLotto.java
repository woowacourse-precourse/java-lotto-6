package lotto.domain;

public class WinningLotto {
    private final Lotto lotto;

    private WinningLotto(Lotto lotto) {
        this.lotto = lotto;
    }

    public static WinningLotto of(Lotto lotto) {
        return new WinningLotto(lotto);
    }
}
