package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class WinLotto {

  private static final List<Lotto> winLotto = new ArrayList<>();
  private final int bonusNumber;

  public WinLotto(int bonusNumber) {
    this.bonusNumber = bonusNumber;
  }

  public int getBonusNumber() {
    return bonusNumber;
  }
}
