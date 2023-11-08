package lotto.view;


import lotto.constant.OutputMessage;
import lotto.model.LottoResult;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {
    private static final String CASH_FORMAT = "###,###";
    private static final String RESULT_SEPARATOR = "---";

    public static void printPurchaseAmountInputMessage() {
        System.out.println(OutputMessage.PURCHASE_AMOUNT_INPUT_MESSAGE);
    }

    public static void printLottoCountMessage(Integer lottoCount) {
        System.out.printf(OutputMessage.LOTTO_COUNT_MESSAGE, lottoCount);
    }

    public static void printLottoBatch(List<String> lottoBatch) {
        lottoBatch.forEach(lotto -> System.out.println(lotto));
        System.out.println();
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println(OutputMessage.WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public static void printBonusNumberInputMessage() {
        System.out.println(OutputMessage.BONUS_NUMBER_INPUT_MESSAGE);
    }

    public static int[] countLottoResult(List<LottoResult> lottoResults) {
        int[] lottoResultCounts = new int[LottoResult.values().length - 1];

        for (LottoResult lottoResult : LottoResult.values()) {
            if (lottoResult.getIndex().equals(-1)) {
                continue;
            }
            lottoResultCounts[lottoResult.getIndex()] = Collections.frequency(lottoResults, lottoResult);
        }

        return lottoResultCounts;
    }

    public static void printLottoResult(List<LottoResult> lottoResults) {
        DecimalFormat formatter = new DecimalFormat(CASH_FORMAT);
        int[] lottoResultCounts = countLottoResult(lottoResults);

        System.out.println(OutputMessage.LOTTO_RESULT_START_MESSAGE);
        System.out.println(RESULT_SEPARATOR);
        for (int i = 0; i < lottoResultCounts.length; i++) {
            LottoResult lottoResult = LottoResult.findByIndex(i);
            if (lottoResult.matchedBonusNumber()) {
                System.out.printf(OutputMessage.LOTTO_RESULT_BONUS_MATCHED_PRINT_MESSAGE, lottoResult.getMatchedWinningNumberCount(), formatter.format(lottoResult.getPrizeMoney()), lottoResultCounts[i]);
                continue;

            }
            System.out.printf(OutputMessage.LOTTO_RESULT_PRINT_MESSAGE, lottoResult.getMatchedWinningNumberCount(), formatter.format(lottoResult.getPrizeMoney()), lottoResultCounts[i]);
        }
    }

    public static void printLottoProfitRate(Float lottoProfitRate) {
        System.out.printf(OutputMessage.LOTTO_PROFIT_RATE_MESSAGE, lottoProfitRate);
    }


}