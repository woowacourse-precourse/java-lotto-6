package lotto.view;

import java.util.Map;
import lotto.model.LotteryResult;
import lotto.model.PersonLotto;
import lotto.model.PurchaseMoney;
import lotto.model.enums.WinningMoney;
import lotto.util.SpecialSign;

public class OutputView {

    private enum OutputMessage {
        PURCHASE_MESSAGE("%d개를 구매했습니다."),
        STATISTICS_MESSAGE("당첨 통계"),
        DIVIDER_MESSAGE("---"),
        THREE_MATCH_MESSAGE("3개 일치 (5,000원) - %d개"),
        FOUR_MATCH_MESSAGE("4개 일치 (50,000원) - %d개"),
        FIVE_MATCH_MESSAGE("5개 일치 (1,500,000원) - %d개"),
        FIVE_AND_BONUS_MATCH_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"),
        SIX_MATCH_MESSAGE("6개 일치 (2,000,000,000원) - %d개"),
        PROFIT_PERCENTAGE_MESSAGE("총 수익률은 "),
        END_MESSAGE("입니다.");

        private final String message;

        OutputMessage(String message) {
            this.message = message;
        }

        public static String statisticsMessage(OutputMessage outputMessage, Map<WinningMoney, Integer> store,
                                               WinningMoney winningMoney) {
            return String.format(outputMessage.message, resultCount(store, winningMoney))
                    + SpecialSign.NEW_LINE.getSign();
        }

        private static int resultCount(Map<WinningMoney, Integer> store, WinningMoney winningMoney) {
            int count = 0;
            if (store.containsKey(winningMoney)) {
                return store.get(winningMoney);
            }
            return count;
        }
    }

    public void outputErrorMessage(IllegalArgumentException ex) {
        System.out.println(ex.getMessage());
        System.out.println();
    }

    public void outputPurchase(PurchaseMoney purchaseMoney, PersonLotto personLotto) {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecialSign.NEW_LINE.getSign())
                .append(String.format(OutputMessage.PURCHASE_MESSAGE.message, purchaseMoney.getPurchaseAmount()))
                .append(SpecialSign.NEW_LINE.getSign())
                .append(purchaseLottoResult(personLotto));

        System.out.println(sb);
    }

    public void outputStatistics(LotteryResult lotteryResult, PurchaseMoney purchaseMoney) {
        StringBuilder sb = new StringBuilder();
        sb.append(SpecialSign.NEW_LINE.getSign())
                .append(OutputMessage.STATISTICS_MESSAGE.message).append(SpecialSign.NEW_LINE.getSign())
                .append(OutputMessage.DIVIDER_MESSAGE.message).append(SpecialSign.NEW_LINE.getSign())
                .append(winningLottoResult(lotteryResult.getStore(), lotteryResult, purchaseMoney));
        System.out.print(sb);
    }

    private String winningLottoResult(Map<WinningMoney, Integer> store, LotteryResult lotteryResult,
                                      PurchaseMoney purchaseMoney) {
        StringBuilder sb = new StringBuilder();
        return sb.append(OutputMessage.statisticsMessage(OutputMessage.THREE_MATCH_MESSAGE, store, WinningMoney.THREE_MATCH))
                .append(OutputMessage.statisticsMessage(OutputMessage.FOUR_MATCH_MESSAGE, store, WinningMoney.FOUR_MATCH))
                .append(OutputMessage.statisticsMessage(OutputMessage.FIVE_MATCH_MESSAGE, store, WinningMoney.FIVE_MATCH))
                .append(OutputMessage.statisticsMessage(OutputMessage.FIVE_AND_BONUS_MATCH_MESSAGE, store, WinningMoney.FIVE_MATCH_BONUS))
                .append(OutputMessage.statisticsMessage(OutputMessage.SIX_MATCH_MESSAGE, store, WinningMoney.SIX_MATCH))
                .append(OutputMessage.PROFIT_PERCENTAGE_MESSAGE.message)
                .append(lotteryResult.getProfitPercentage(purchaseMoney))
                .append(SpecialSign.PERCENTAGE_MESSAGE.getSign())
                .append(OutputMessage.END_MESSAGE.message)
                .toString();
    }

    private String purchaseLottoResult(PersonLotto personLotto) {
        return personLotto.getElements();
    }
}
