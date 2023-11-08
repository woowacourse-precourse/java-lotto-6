package lotto.model;

import static lotto.view.ExceptionMessage.LENGTH_6_ERROR;
import static lotto.view.ExceptionMessage.WINNING_DUPLICATE_ERROR;
import static lotto.view.ExceptionMessage.WINNING_RANGE_ERROR;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class WinningNumber {
  private final List<Integer> winningNum;

  public WinningNumber(List<Integer> winningNum) {
    validateWinning(winningNum);
    this.winningNum = winningNum;
  }

  private void validateWinning(List<Integer> winningNum) {
    if (winningNum.size() != 6) {
      throw new IllegalArgumentException(LENGTH_6_ERROR);
    }
    Set<Integer> uniqueNumbers = new HashSet<>(winningNum);
    if (uniqueNumbers.size() != 6) {
      throw new IllegalArgumentException(WINNING_DUPLICATE_ERROR);
    }

    for (Integer number : winningNum) {
      if (number < 1 || number > 45) {
        throw new IllegalArgumentException(WINNING_RANGE_ERROR);
      }
    }
  }

  @Override
  public String toString() {
    return winningNum.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]\n"));
  }
}
