package lotto.model;

import java.util.List;
import lotto.validation.LotteryNumberValidator;

public class LotteryCalculator extends LotteryPolicy {

  public static int divideByLottoPrice(String amount) {
    LotteryNumberValidator.validateNumberFormat(amount);
    int newAmount = Integer.parseInt(amount);
    LotteryNumberValidator.validatePurchaseAmountDivisibility(newAmount);
    return newAmount / LOTTO_PRICE;
  }

  public static int[] calculateResult(List<Lotto> lottoTickets, List<Integer> winningNumbers,
      int bonusNumber) {
    int[] result = new int[5];
    for (Lotto lotto : lottoTickets) {
      int count = matchAndCountWinningNumbers(lotto, winningNumbers);
      matchNumbers(result, lotto, count, bonusNumber);
    }
    return result;
  }

  private static void matchNumbers(int[] result, Lotto lotto, int count, int bonusNumber) {
    if (count == 3) {
      result[0]++;
      return;
    }
    if (count == 4) {
      result[1]++;
      return;
    }
    if (count == 5) {
      match5Numbers(result, lotto, bonusNumber);
      return;
    }
    if (count == 6) {
      result[4]++;
    }
  }

  private static void match5Numbers(int[] result, Lotto lotto, int bonusNumber) {
    if (matchBonusNumber(lotto, bonusNumber)) {
      result[3]++;
      return;
    }
    result[2]++;
  }

  public static int matchAndCountWinningNumbers(Lotto lotto, List<Integer> winningNumbers) {
    return (int) lotto.getNumbers().stream()
        .filter(winningNumbers::contains)
        .count();
  }

  public static boolean matchBonusNumber(Lotto lotto, int bonusNumber) {
    return lotto.getNumbers().contains(bonusNumber);
  }
}
