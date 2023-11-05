package lotto.model;

import java.util.List;

public class ComputerLotto {

  private Lotto lotto;

  public ComputerLotto(Lotto lotto) {
    this.lotto = lotto;
  }

  public List<Integer> getLottoNumbers() {
    return lotto.getNumbers();
  }
}
