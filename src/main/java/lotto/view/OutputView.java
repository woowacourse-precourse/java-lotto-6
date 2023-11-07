package lotto.view;

import java.util.Map;
import javax.swing.Spring;
import lotto.model.LotteryResult;
import lotto.model.PersonLotto;
import lotto.model.PurchaseMoney;
import lotto.model.WinningMoney;
import lotto.util.Constants;
import lotto.util.SpecialSign;

public class OutputView {

  private enum OutputMessage {
    PURCHASE_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    STATISTICS_MESSAGE("당첨 통계"),
    DIVIDER_MESSAGE("---"),
    THREE_MATCH_MESSAGE("3개 일치 (5,000원) - "),
    FOUR_MATCH_MESSAGE("4개 일치 (50,000원) - "),
    FIVE_MATCH_MESSAGE("5개 일치 (1,500,000원) - "),
    FIVE_AND_BONUS_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX_MATCH_MESSAGE("6개 일치 (2,000,000,000원) - "),
    COUNT_MESSAGE("개"),
    PROFIT_PERCENTAGE_MESSAGE("총 수익률은 "),
    END_MESSAGE("입니다.");

    private final String message;

    OutputMessage(String message) {
      this.message = message;
    }
  }

  public void outputPurchase(PurchaseMoney purchaseMoney, PersonLotto personLotto) {
    StringBuilder sb = new StringBuilder();
    sb.append(SpecialSign.NEW_LINE.getSign())
        .append(purchaseMoney.getPurchaseAmount())
        .append(OutputMessage.PURCHASE_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(purchaseLottoResult(personLotto));

    System.out.println(sb);
  }

  public void outputResult(LotteryResult lotteryResult, PurchaseMoney purchaseMoney) {
    StringBuilder sb = new StringBuilder();
    sb.append(OutputMessage.STATISTICS_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(OutputMessage.DIVIDER_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(winningLottoResult(lotteryResult.getStore()))
        .append(SpecialSign.NEW_LINE.getSign())
        .append(OutputMessage.PROFIT_PERCENTAGE_MESSAGE.message)
        .append(lotteryResult.getProfitPercentage(purchaseMoney))
        .append(SpecialSign.PERCENTAGE_MESSAGE.getSign())
        .append(OutputMessage.END_MESSAGE.message);

    System.out.println(sb);
  }

  private String winningLottoResult(Map<WinningMoney, Integer> store) {
    StringBuilder sb = new StringBuilder();
    return sb.append(OutputMessage.THREE_MATCH_MESSAGE.message)
        .append(resultCount(store, WinningMoney.THREE_MATCH)).append(OutputMessage.COUNT_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(OutputMessage.FOUR_MATCH_MESSAGE.message)
        .append(resultCount(store, WinningMoney.FOUR_MATCH)).append(OutputMessage.COUNT_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(OutputMessage.FIVE_MATCH_MESSAGE.message)
        .append(resultCount(store, WinningMoney.FIVE_MATCH)).append(OutputMessage.COUNT_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(OutputMessage.FIVE_AND_BONUS_MATCH_MESSAGE.message)
        .append(resultCount(store, WinningMoney.FIVE_MATCH_BONUS)).append(OutputMessage.COUNT_MESSAGE.message)
        .append(SpecialSign.NEW_LINE.getSign())
        .append(OutputMessage.SIX_MATCH_MESSAGE.message)
        .append(resultCount(store, WinningMoney.SIX_MATCH)).append(OutputMessage.COUNT_MESSAGE.message)
        .toString();
  }

  private int resultCount(Map<WinningMoney, Integer> store, WinningMoney winningMoney) {
    int count = 0;
    if (store.containsKey(winningMoney)) return store.get(winningMoney);
    return count;
  }

  private String purchaseLottoResult(PersonLotto personLotto) {
    StringBuilder sb = new StringBuilder();
    personLotto.getPurchaseLotto().forEach(lotto -> {
      StringBuilder sub = new StringBuilder();
      sub.append(SpecialSign.LEFT_BRACKET.getSign());

      for (int number : lotto.getNumbers()) {
        sub.append(number)
            .append(SpecialSign.SEPARATOR.getSign())
            .append(SpecialSign.BLANK.getSign());
      }

      sub.delete(sub.length() - Constants.REMOVE_INDEX, sub.length());
      sub.append(SpecialSign.RIGHT_BRACKET.getSign())
          .append(SpecialSign.NEW_LINE.getSign());

      sb.append(sub);
    });

    return sb.toString();
  }
}
