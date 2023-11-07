package lotto;

import java.util.List;

public class WinningLotto {
  private final Lotto lotto;
  private final int bonusBall;
  
  public WinningLotto(List<Integer> numbers, int bonusBall) {
    this.lotto = new Lotto(numbers);
    this.bonusBall = bonusBall;
  }
  
  public Lotto getLotto() {
    return lotto;
  }
  
  public boolean isSecondRank(Lotto lotto) {
    return this.lotto.countMatchedNumbers(lotto) == 5 && lotto.contains(bonusBall);
  }
}
