package lotto.model;

/**
 *  @Method  : 당첨 로또 클래스
 */
public class WinLotto {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinLotto(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }
}
