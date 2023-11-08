package domain;

public class WinningNumber {
    private final int MIN_NUMBER = 1;
    private final int MAX_NUMBER = 45;
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final Lotto winningNumber;
    private final int bonusNumber;

    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        validate(winningNumber, bonusNumber);
        validateNumberRange(bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 값이 있습니다.");
        }
    }

    private void validateNumberRange(int number) throws IllegalArgumentException {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    public int countMatch(Lotto lotto) {
        int count = 0;
        for (Integer playerNumber : lotto.getNumbers()) {
            if (winningNumber.getNumbers().contains(playerNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean isMatchBonusNumber(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
