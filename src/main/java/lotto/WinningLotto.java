package lotto;

public class WinningLotto {
    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, Integer bonusNumber) {
        this.lotto = lotto;
        validate(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validate(Integer bonusNumber) {
        checkDuplication(bonusNumber);
    }

    private void checkDuplication(Integer bonusNumber) {
        if (this.lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(CustomErrorMessage.DUPLICATED_BONUS_NUMBER);
        }
    }
}
