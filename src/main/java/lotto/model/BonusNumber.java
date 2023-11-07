package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionMessage;

public class BonusNumber {
  private int bonusNum;


  public BonusNumber(int bonusNum, List<Integer> winning) {
    validateBonus(bonusNum, winning);
    this.bonusNum = bonusNum;
  }

  private void validateBonus(int bonusNum, List<Integer> winning) {
    if (bonusNum < 1 || bonusNum > 45) {
      ExceptionMessage.rangeException();
      throw new IllegalArgumentException();
    }
    if (winning.contains(bonusNum)) {
      ExceptionMessage.duplicateException();
      throw new IllegalArgumentException();
    }
  }
}
