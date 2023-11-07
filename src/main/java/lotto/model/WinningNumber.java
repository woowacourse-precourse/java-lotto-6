package lotto.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.view.ExceptionMessage;

public class WinningNumber {
  private final List<Integer> winningNum;

  public WinningNumber(List<Integer> winningNum) {
    validateWinning(winningNum);
    this.winningNum = winningNum;
  }

  private void validateWinning(List<Integer> winningNum) {
    if (winningNum.size() != 6) {
      ExceptionMessage.length6Exception();
      throw new IllegalArgumentException();
    }
    Set<Integer> uniqueNumbers = new HashSet<>(winningNum);
    if (uniqueNumbers.size() != 6) {
      ExceptionMessage.duplicateException();
      throw new IllegalArgumentException();
    }

    for (Integer number : winningNum) {
      if (number < 1 || number > 45) {
        ExceptionMessage.rangeException();
        throw new IllegalArgumentException();
      }
    }
  }
}
