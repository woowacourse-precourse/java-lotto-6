package lotto.model;

import java.util.List;

public class WinningLotto {

  private Lotto winningLotto;
  private int bonusNumber;


  public WinningLotto(List<Integer> winningNumbers, int bonusNumber) {
    validateBonusNumber(winningNumbers, bonusNumber);
    this.winningLotto = new Lotto(winningNumbers);
    this.bonusNumber = bonusNumber;
  }

  public Lotto getWinningLotto() {
    return winningLotto;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }
  private void validateBonusNumber(List<Integer> winningNumbers, int bonusNumber) {
    if (winningNumbers.contains(bonusNumber)) {
      throw new IllegalArgumentException("당첨 번호에 중복된 숫자가 있습니다.");
    }
  }
}
