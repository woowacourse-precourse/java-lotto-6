package lotto.view;

import static lotto.constant.OutputMessage.PURCHASE_COUNT_DEFAULT_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_BONUS_NUMBER_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_PURCHASE_PRICE_MESSAGE;
import static lotto.constant.OutputMessage.REQUEST_WINNING_NUMBER_MESSAGE;
import static lotto.constant.WinningConstant.WINNING_MAX_COUNT;
import static lotto.constant.WinningConstant.WINNING_MIN_COUNT;
import static lotto.constant.WinningConstant.WINNING_RESULT_FORMAT;

import java.util.List;
import java.util.Map;
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
        System.out.println("당첨 통계\n---");
        for (int i = WINNING_MIN_COUNT; i <= WINNING_MAX_COUNT; i++) {
            String lotteryPrize = LotteryResult.values()[i].getConvertedPrize();
            Integer lotteryCount = lotteryResults.get(LotteryResult.values()[i]);
            System.out.printf((WINNING_RESULT_FORMAT) + "%n", i, lotteryPrize, lotteryCount);
        }
    }
}
