package lotto.model;

public class WinLotto {
    private final Lotto lotto;
    private final Integer bonusNumber;

    public WinLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
