package lotto.domain;

public class WinningLotto {
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 45;

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningLotto(Lotto lotto, int bonusNumber) {
        validate(lotto, bonusNumber);
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) {
        validateNumberRange(bonusNumber);
        validateDuplicateNumber(winningLotto, bonusNumber);
    }

    private void validateNumberRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_NUMBER || bonusNumber > MAXIMUM_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNumber(Lotto winningLotto, int bonusNumber) {
        if (winningLotto.contains(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Integer number) {
        return lotto.contains(number);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
