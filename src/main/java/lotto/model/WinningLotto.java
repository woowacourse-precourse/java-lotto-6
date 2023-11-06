package lotto.model;

public class WinningLotto {
    private final int bonusNumber;
    private final Lotto winningLotto;

    public WinningLotto(Lotto lotto, String bonus) {
        winningLotto = lotto;
        validateBonusNumber(winningLotto, bonus);
        bonusNumber = Integer.parseInt(bonus);
    }

}
