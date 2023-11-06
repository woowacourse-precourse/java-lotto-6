package lotto.model;

public class Bonus {

  private Number bonusNumber;

  public Bonus(Number bonusNumber, WinningLotto winningLotto) {
    validateDuplicatedInWinningLotto(bonusNumber, winningLotto);
    this.bonusNumber = bonusNumber;
  }

  public int getBonusNumber() {
    return bonusNumber.getNumber();
  }

  private void validateDuplicatedInWinningLotto(Number bonusNumber, WinningLotto winningLotto) {
    if (isDuplicate(bonusNumber, winningLotto)) {
      throw new IllegalArgumentException("보너스 숫자가 중복됩니다.");
    }
  }

  private boolean isDuplicate(Number bonusNumber, WinningLotto winningLotto) {
    return winningLotto.getWinningNumbers().contains(bonusNumber.getNumber());
  }
}
