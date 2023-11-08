package lotto;

import java.util.List;

public class WinningLotto {
  private final Lotto lotto;
  private final int bonusBall;
  
  //  당첨 번호와 보너스 볼을 가지고 WinningLotto 객체를 생성하는 생성자.
  public WinningLotto(List<Integer> winningNumbers, int bonusBall) {
    this.lotto = new Lotto(winningNumbers);
    this.bonusBall = bonusBall;
  }
  
  //  로또의 등수를 판별하는 메서드.
  public LottoRank rank(Lotto lotto) {
    int countOfMatch = lotto.countMatchedNumbers(this.lotto);
    boolean matchBonus = lotto.contains(bonusBall);
    return LottoRank.valueOf(countOfMatch, matchBonus);
  }
}