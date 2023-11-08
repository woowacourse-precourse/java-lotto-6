package lotto.Input.winningnumber;

import java.util.List;
import lotto.Lotto;

public class NumberEnteredEvent {

  private final Lotto winningLotto;

  private final ValidatedBonusNumber bonusNumber;


  private NumberEnteredEvent(Lotto winningLotto, ValidatedBonusNumber bonusNumber) {
    this.winningLotto = winningLotto;
    this.bonusNumber = bonusNumber;
  }

  public static NumberEnteredEvent of(Lotto winningLotto, ValidatedBonusNumber bonusNumber) {
    return new NumberEnteredEvent(winningLotto, bonusNumber);
  }

  public Lotto getWinningLotto() {
    return winningLotto;
  }

  public ValidatedBonusNumber getBonusNumber() {
    return bonusNumber;
  }
}
