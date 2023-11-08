package lotto.View;

import java.util.List;
import java.util.Map;
import lotto.Model.Lotto;
import lotto.Model.WinningResult;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";
    private static final String UNIT_MESSAGE = "개";
    private static final String TOTAL_PROFIT_RATE_MESSAGE = "총 수익률은 ";
    private static final String PERCENT_STATEMENT_MESSAGE = "%입니다.";

    public static void printLottoAmount(int lottoPurchaseCount) {

        System.out.println(lottoPurchaseCount + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottoList(List<Lotto> lottoList) {

        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getLottoNumbers();
            System.out.println(lottoNumbers);
        }
    }

    public static void printSuccessResult() {
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(LINE_MESSAGE);
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + UNIT_MESSAGE);
    }


    public static void printProfitRate(double profitRate) {
        System.out.println(TOTAL_PROFIT_RATE_MESSAGE + String.format("%.1f", profitRate) + PERCENT_STATEMENT_MESSAGE);
    }
}
