package lotto.model;

public class WinningCombination {
    private static final String BONUS_NUMBER_DUPLICATION_EXCEPTION = "보너스 번호는 당첨 번호와 중복될 수 없습니다.";

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    private WinningCombination(Lotto winningLotto, LottoNumber bonusNumber) {
        validateBonusNumberNotDuplicated(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumberNotDuplicated(Lotto winningLotto, LottoNumber bonusNumber) {
        if (winningLotto.hasNumber(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATION_EXCEPTION);
        }
    }

    public static WinningCombination of(Lotto winningLotto, LottoNumber bonusNumber) {
        return new WinningCombination(winningLotto, bonusNumber);
    }

    public boolean hasLottoNumber(LottoNumber number) {
        return winningLotto.hasNumber(number);
    }

    public boolean hasBonusNumber(LottoNumber number) {
        return bonusNumber.equals(number);
    }
}
