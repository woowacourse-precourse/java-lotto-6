package lotto.domain.model;


public class WinningNumbers {

    private final Lotto winningLotto;
    private final LottoNumber bonusNumber;

    public WinningNumbers(final Lotto lotto, final int bonusNumber) {
        this.winningLotto = lotto;
        this.bonusNumber = new LottoNumber(bonusNumber);
        validateBonusNumberDuplication();
    }

    private void validateBonusNumberDuplication() {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(
                    LottoErrorMessages.BONUS_NUMBER_DUPLICATED.getMessage());
        }
    }


    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public LottoNumber getBonusNumber() {
        return bonusNumber;
    }
}