package lotto;

import java.util.Arrays;

public enum LottoRank {
  //  1등_6개 일치.
  FIRST(6, 2_000_000_000),
  //  2등_5개 일치, 보너스 볼 일치.
  SECOND(5, 30_000_000),
  //  3등_5개 일치.
  THIRD(5, 1_500_000),
  //  4등_4개 일치.
  FOURTH(4, 50_000),
  //  5등_3개 일치.
  FIFTH(3, 5_000),
  //  당첨금 x.
  MISS(0, 0);
  
  //  일치하는 번호의 갯수.
  private final int countOfMatch;
  //  당첨금.
  private final int winningMoney;
  
  //  생성자.
  LottoRank(int countOfMatch, int winningMoney) {
    this.countOfMatch = countOfMatch;
    this.winningMoney = winningMoney;
  }
  
  //  일치하는 번호의 갯수와 보너스 볼 일치 여부에 따라 당첨 등수를 반환한다.
  public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
    if (countOfMatch == 5 && matchBonus) {
      return SECOND;
    }
    return Arrays.stream(values())
        .filter(rank -> rank.countOfMatch == countOfMatch)
        .findFirst()
        .orElse(MISS);
  }
  
  public int getCountOfMatch() {
    return countOfMatch;
  }
  
  public int getWinningMoney() {
    return winningMoney;
  }
}