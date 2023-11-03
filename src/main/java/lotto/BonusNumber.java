package lotto;

public class BonusNumber {

    private static final int MIN_INCLUDE = 1;
    private static final int MAX_INCLUDE = 45;
    private int bonusNumber;

    public BonusNumber(Lotto winningLotto, int bonusNumber) throws IllegalArgumentException {
        validate(winningLotto, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

    private void validate(Lotto winningLotto, int bonusNumber) throws IllegalArgumentException {
        validateDuplicate(winningLotto, bonusNumber);
        validateRange(bonusNumber);
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNumber) throws IllegalArgumentException {
        if (winningLotto.containsGivenNumber(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(int bonusNumber) {
        if (bonusNumber < MIN_INCLUDE || bonusNumber > MAX_INCLUDE) {
            throw new IllegalArgumentException();
        }
    }
}
