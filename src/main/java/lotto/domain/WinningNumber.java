package lotto.domain;

public class WinningNumber {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningNumber(Lotto lotto, int bonusNumber) {
        this.winningLotto = lotto;

        validateBonusNumber(bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber) {
        for (int number : winningLotto.getNumbers()) {
            if(bonusNumber == number) {
                throw new IllegalArgumentException();
            }
        }
    }

    public int calcMatchCount (Lotto lotto) {
        return lotto.calcMatchNumber(winningLotto);
    }

    public int calcBonussMatchCount (Lotto lotto) {
        if(lotto.isNumberInLotto(bonusNumber)){
            return 1;
        }

        return 0;
    }
}
