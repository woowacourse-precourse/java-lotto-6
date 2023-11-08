package lotto;

import java.util.List;

public class WinningLotto {
  private final Lotto lotto;
  private final int bonusBall;
  
  public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
    this.lotto = new Lotto(winningNumbers);
    this.bonusBall = bonusBall;
  }
  
  public LottoRank rank(Lotto lotto) {
    int countOfMatch = lotto.countMatchedNumbers(this.lotto);
    boolean matchBonus = lotto.contains(bonusBall);
    return LottoRank.valueOf(countOfMatch, matchBonus);
  }
}
