package lotto.domain.lotto;

public class WinningLotto {
    private final Lotto winningNumbers;
    private final BonusNumber bonusNumber;

    private WinningLotto(Lotto winningNumbers, BonusNumber bonusNumber) {
        verifyBonusNumberNotMatchingWinningNumbers();
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static WinningLotto from(Lotto numbers, BonusNumber bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }


    private void verifyBonusNumberNotMatchingWinningNumbers() {
        if (bonusNumber.isMatching(winningNumbers)) {
            throw new IllegalArgumentException("입력한 당첨번호와 동일한 숫자를 입력하면 안 됩니다.");
        }
    }
}


