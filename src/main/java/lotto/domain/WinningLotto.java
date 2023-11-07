package lotto.domain;

public class WinningLotto {
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningLotto(Lotto winningNumber, int bonusNumber) {
        validate(bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(int bonusNumber) {
        Lotto.validateNumberRange(bonusNumber);
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(Lotto.DUPLICATE_NUMBER_MESSAGE);
        }
    }

    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }


}
