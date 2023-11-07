package lotto.view;

import java.util.List;
import lotto.service.LottoService;
import lotto.service.LottoWinningCalculator;
import lotto.utils.constants.Comment;
import lotto.utils.constants.LottoWinning;

public class OutputView {

    public static void printGameStartMessage() {
        System.out.println(Comment.INPUT_PURCHASE_AMOUNT.getComment());
    }

    public static void printLottoPurchaseAmount(int lottoNumber) {
        LottoService.amountPurchaseDivide(lottoNumber);
        System.out.println();
        System.out.println(lottoNumber + Comment.OUTPUT_PURCHASE_AMOUNT.getComment());
    }

    public static void printLottoNumber(List<List<Integer>> lottoAllNumbers) {
        for (List<Integer> lottoNumbers : lottoAllNumbers) {
            System.out.println(lottoNumbers);
        }
        System.out.println();
        System.out.println(Comment.INPUT_WINNING_NUMBER.getComment());
    }

    public static void printLottoBonusNumber() {
        System.out.println();
        System.out.println(Comment.INPUT_BONUS_NUMBER.getComment());
    }

    public static void printLottoWinningStatistics(List<Integer> lottoWinningCounts) {
        System.out.println();
        System.out.println(Comment.INPUT_THREE_DASH.getComment());
        System.out.println(Comment.INPUT_WINNING_STATISTICS.getComment());
    }

    public static void printLottoTotalProfit(List<Integer> lottoWinningCounts, int purchaseAmount) {
        LottoWinningCalculator.printTotalProfit(lottoWinningCounts, purchaseAmount);
    }
}
