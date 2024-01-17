package lotto.sevice;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.UserInputNumbers;
import lotto.domain.WinningCheck;

public class Calculator {

  private static final int PERCENTAGE_FACTOR = 100;

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

  public double calculateProfitRate(PurchaseAmount purchaseAmount,
      Map<WinningCheck, Integer> result) {
    double totalPrize = 0;
    for (Map.Entry<WinningCheck, Integer> entry : result.entrySet()) {
      WinningCheck prize = entry.getKey();
      int count = entry.getValue();
      totalPrize += Double.parseDouble(prize.getPrizeAmount()
          .replace(",", "")) * count;
    }

    double profitRate = (totalPrize / purchaseAmount.getAmount()) * PERCENTAGE_FACTOR;
    DecimalFormat df = new DecimalFormat("#.##");
    return Double.parseDouble(df.format(profitRate));
  }
}
