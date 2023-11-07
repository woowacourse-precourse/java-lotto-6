package lotto.domain;

/**
 * @author 민경수
 * @description winning lotto
 * @since 2023.11.06
 **********************************************************************************************************************/
public class WinningLotto {

    private final Lotto winningLotto;
    private final BonusBall bonusNumber;

    public WinningLotto(Lotto winningLotto, BonusBall bonusNumber) {
        this.winningLotto = winningLotto;

        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto of(Lotto winningLotto, BonusBall bonusNumber) {
        return new WinningLotto(winningLotto, bonusNumber);
    }

    public int getMatchedCountCompareTo(Lotto boughtLotto) {
        return winningLotto.getMatchedCountCompareTo(boughtLotto);
    }

    public boolean isBonusNumMatchedTo(Lotto boughtLotto) {
        return boughtLotto.contains(bonusNumber);
    }

}