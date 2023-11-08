package lotto.domain;

import java.util.function.BiPredicate;
import java.util.Arrays;

public enum Prize {
  FAIL(0, 0, (matchLottoNumber, containBonusNumber) -> matchLottoNumber < 3),
  FIFTH(5000, 3, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 3),
  FOURTH(50000, 4, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 4),
  THIRD(1500000, 5, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && !containBonusNumber),
  SECOND(30000000, 5, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 5 && containBonusNumber),
  FIRST(2000000000, 6, (matchLottoNumber, containBonusNumber) -> matchLottoNumber == 6);

  private final int money;
  private final int matchLottoNumber;
  private final BiPredicate<Integer, Boolean> isMatch;

  Prize(int money, int matchLottoNumber, BiPredicate<Integer, Boolean> isMatch) {
    this.money = money;
    this.matchLottoNumber = matchLottoNumber;
    this.isMatch = isMatch;
  }

  public static Prize getPrize(int matchLottoNumber, boolean containBonusNumber) {
    return Arrays.stream(Prize.values())
            .filter(prize -> prize.isMatch.test(matchLottoNumber, containBonusNumber))
            .findFirst()
            .orElse(FAIL);
  }

  public int getMoney() {
    return money;
  }

  public int getMatchLottoNumber() {
    return matchLottoNumber;
  }
}