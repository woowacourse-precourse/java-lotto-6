package domain;


public class WinningNumber {
    private final String ERROR_MESSAGE = "[ERROR] ";
    private final Lotto winningNumber;
    private final int bonusNumber;
    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        validate(winningNumber,bonusNumber);
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Lotto winningNumber, int bonusNumber) {
        if (winningNumber.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "중복된 값이 있습니다.");
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

}
