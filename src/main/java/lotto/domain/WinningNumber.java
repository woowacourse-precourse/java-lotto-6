package lotto.domain;

public class WinningNumber {
    private Lotto lotto;
    private int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        for (int number : lotto.getNumbers()) {
            if(bonusNumber == number) {
                throw new IllegalArgumentException();
            }
        }
    }
}
