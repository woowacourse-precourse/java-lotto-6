package lotto.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.UserInputNumbers;
import lotto.domain.WinningCheck;

public class LottoResultCalculator {

  public Map<WinningCheck, Integer> calculateWinningResult(List<Lotto> lottos,
      UserInputNumbers receivedLotto) {
    Map<WinningCheck, Integer> result = new HashMap<>(); // WinningCheck 객체 정수를 키와 값으로 Map에 저장
    for (Lotto lotto : lottos) {
      int matchCount = lotto.getMatchCount(receivedLotto);
      boolean bonusMatch = lotto.isBonusMatch(receivedLotto); // receivedLotto는 bonus를 포함하고있음

      WinningCheck prize = WinningCheck.getPrize(matchCount, bonusMatch);
      result.merge(prize, 1, Integer::sum);
    }
    return result;
  }
}
