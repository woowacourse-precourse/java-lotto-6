package lotto.view;

import static lotto.constant.OutputViewConstant.COUNT_POSTFIX_MESSAGE;
import static lotto.constant.OutputViewConstant.FIFTH_PRIZE_MESSAGE;
import static lotto.constant.OutputViewConstant.FIRST_PRIZE_MESSAGE;
import static lotto.constant.OutputViewConstant.FOURTH_PRIZE_MESSAGE;
import static lotto.constant.OutputViewConstant.PURCHASE_MESSAGE;
import static lotto.constant.OutputViewConstant.RETURN_RATE_MESSAGE_POSTFIX;
import static lotto.constant.OutputViewConstant.RETURN_RATE_MESSAGE_PREFIX;
import static lotto.constant.OutputViewConstant.SECOND_PRIZE_MESSAGE;
import static lotto.constant.OutputViewConstant.THIRD_PRIZE_MESSAGE;
import static lotto.constant.OutputViewConstant.WINNING_STATS_MESSAGE;
import static lotto.constant.PrizeConstant.fifthPrizeCount;
import static lotto.constant.PrizeConstant.firstPrizeCount;
import static lotto.constant.PrizeConstant.fourthPrizeCount;
import static lotto.constant.PrizeConstant.secondPrizeCount;
import static lotto.constant.PrizeConstant.thirdPrizeCount;
import static lotto.service.LottoService.lottoNumberLists;
import static lotto.service.LottoService.returnRate;
import static lotto.service.OutputService.quantity;

import java.util.List;

public class OutputView {
    public static void printPurchaseMessage() {
        System.out.print("\n" + quantity + PURCHASE_MESSAGE);
    }

    public static void printLottoNumbers() {
        for (List<Integer> list : lottoNumberLists) {
            System.out.println(list);
        }
    }

    public static void printWinningStatsMessage() {
        System.out.println("\n" + WINNING_STATS_MESSAGE);
    }

    public static void printWinningStats() {
        System.out.printf(
                FIFTH_PRIZE_MESSAGE + "%d" + COUNT_POSTFIX_MESSAGE + "\n" +
                        FOURTH_PRIZE_MESSAGE + "%d" + COUNT_POSTFIX_MESSAGE + "\n" +
                        THIRD_PRIZE_MESSAGE + "%d" + COUNT_POSTFIX_MESSAGE + "\n" +
                        SECOND_PRIZE_MESSAGE + "%d" + COUNT_POSTFIX_MESSAGE + "\n" +
                        FIRST_PRIZE_MESSAGE + "%d" + COUNT_POSTFIX_MESSAGE + "\n",
                fifthPrizeCount, fourthPrizeCount, thirdPrizeCount, secondPrizeCount, firstPrizeCount
        );
    }

    public static void printReturnRateMessage() {
        System.out.printf(RETURN_RATE_MESSAGE_PREFIX + "%.1f" + RETURN_RATE_MESSAGE_POSTFIX + "\n", returnRate);
    }
}
