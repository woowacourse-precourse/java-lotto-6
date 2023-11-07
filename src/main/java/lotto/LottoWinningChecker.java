package lotto;

public class LottoWinningChecker {
    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    LottoWinningChecker(Lotto winningLotto, Integer bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = new LottoNumber(bonusNumber);

        validateDuplicateBonusNumber(winningLotto);
    }

    private void validateDuplicateBonusNumber(Lotto winningLotto) {
        if (winningLotto.containLottoNumber(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

    public LottoResult check(Lotto lotto) {
        int matchCount = winningLotto.compareLottoNumber(lotto);
        boolean containBonusNumber = lotto.containLottoNumber(bonusNumber);

        return LottoRule.of(matchCount, containBonusNumber);
    }
}
