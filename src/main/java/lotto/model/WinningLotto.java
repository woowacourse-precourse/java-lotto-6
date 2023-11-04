package lotto.model;

public class WinningLotto {

    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
