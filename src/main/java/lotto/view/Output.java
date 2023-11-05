package lotto.view;

import static lotto.constant.OutputMessage.PURCHASE_COUNT_DEFAULT_MESSAGE;
import static lotto.constant.OutputMessage.RATE_OF_REVENUE_FORMAT;
import static lotto.constant.OutputMessage.REQUEST_BONUS_NUMBER_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_PURCHASE_PRICE_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_WINNING_NUMBER_MESSAGE;
import static lotto.constant.OutputMessage.WINNING_RESULT_FORMAT;
import static lotto.constant.OutputMessage.WINNING_SECOND_FORMAT;
import static lotto.constant.WinningConstant.WINNING_MAX_COUNT;
import static lotto.constant.WinningConstant.WINNING_MIN_COUNT;

import java.util.List;
import java.util.Map;
import lotto.constant.OutputMessage;
import lotto.domain.LotteryResult;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.domain.PurchasePrice;

public class Output {

    public static void newLine() {
        System.out.println();
    }

    public static void errorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void requestPurchasePrice() {
        System.out.println(REQUEST_PURCHASE_PRICE_MESSAGE);
    }

    public void purchaseCount(PurchasePrice purchasePrice) {
        System.out.println(purchasePrice.calculatePurchaseCount() + PURCHASE_COUNT_DEFAULT_MESSAGE);
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBER_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void purchasedLotts(Player player) {
        List<Lotto> lottos = player.getLottos();
        lottos.forEach((lotto -> System.out.println(lotto.getNumbers())));
        System.out.println();
    }

    public void winningResult(Map<LotteryResult, Integer> lotteryResults) {
        System.out.println(OutputMessage.DEFAULT_WINNING_RESULT_MESSAGE);
        for (int count = WINNING_MIN_COUNT; count <= WINNING_MAX_COUNT; count++) {
            String lotteryPrize = LotteryResult.values()[count].getConvertedPrize();
            Integer lotteryCount = lotteryResults.get(LotteryResult.values()[count]);
            System.out.println(String.format(WINNING_RESULT_FORMAT, count, lotteryPrize, lotteryCount));
            secondWinningResult(count, lotteryResults);
        }
    }

    private void secondWinningResult(int winningCount, Map<LotteryResult, Integer> lotteryResults) {
        if (winningCount == 5) {
            Integer lotteryCount = lotteryResults.get(LotteryResult.values()[winningCount]);
            System.out.println(String.format(WINNING_SECOND_FORMAT, lotteryCount));
        }

    }

    public void rateOfRevenue(double rateOfRevenue) {
        System.out.println(String.format(RATE_OF_REVENUE_FORMAT, rateOfRevenue));
    }
}
