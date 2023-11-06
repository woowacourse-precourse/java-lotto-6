package lotto.model;

import java.util.List;

public class WinningLotto {

  private Lotto winningLotto;

  public WinningLotto(Lotto winningLotto) {
    this.winningLotto = winningLotto;
  }

  public List<Integer> getWinningNumbers() {
    return winningLotto.getNumbers();
  }
}
