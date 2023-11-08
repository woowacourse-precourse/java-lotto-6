package lotto;

import java.util.List;
import lotto.statistics.calculatewinning.NotWin;
import lotto.statistics.calculatewinning.Win;
import lotto.statistics.calculatewinning.WinningResults;

public class Lotto {

  private final List<Integer> numbers;

  public Lotto(List<Integer> numbers) {
    validate(numbers);
    this.numbers = numbers;
  }

  private void validate(List<Integer> numbers) {
    if (numbers.size() < 6 || numbers.stream().anyMatch(number -> number < 1 || number > 45)
        || numbers.stream().distinct().count() != 6) {
      throw new IllegalArgumentException("로또 번호는 6개의 숫자로 이루어져야 하며, 1~45 사이의 숫자만 가능합니다.");
    }
  }

  public List<Integer> getNumbers() {
    return numbers;
  }

  public int size() {
    return numbers.size();
  }

  public int matchCount(Lotto winningNumber) {
    return (int) numbers.stream().filter(number -> winningNumber.getNumbers().contains(number))
        .count();
  }

  public WinningResults<NotWin, Win> match(Lotto winningNumber) {
    int matchCount = matchCount(winningNumber);
    if (Win.isWin(matchCount)) {
      return WinningResults.win(Win.findWin(matchCount).get());
    }
    return WinningResults.notWin(NotWin.NOT_WIN);
  }

  public boolean matchBonusNumber(int bonusNumber) {
    return numbers.contains(bonusNumber);
  }

  @Override
  public String toString() {
    return "Lotto{" +
        "numbers=" + numbers +
        '}';
  }
}
