package lotto.model;

public class WinningNumbers {
    private static final String BONUS_NUMBER_NOT_ALLOWED_MESSAGE = "[ERROR] 보너스 번호는 당첨 번호에 포함될 수 없습니다.";
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;

    public WinningNumbers(Lotto winningLotto, int bonusNumber) {
        validate(winningLotto, bonusNumber);
        this.winningLotto = winningLotto;
        this.bonusNumber = new BonusNumber(bonusNumber);
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        checkBonusNumberInWinningLotto(winningLotto, bonusNumber);
    }

    private void checkBonusNumberInWinningLotto(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_NOT_ALLOWED_MESSAGE);
        }
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public int getBonusNumber() {
        return bonusNumber.getBonusNumber();
    }

}
