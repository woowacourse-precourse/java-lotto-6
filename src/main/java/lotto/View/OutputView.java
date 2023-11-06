package lotto.View;

import java.util.List;
import lotto.Domain.Lotto;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";
    private static final int MIN_MATCHING_COUNT = 3;
    private static final int MAX_MATCHING_COUNT = 6;

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
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static void printSuccessMessage(String message, int numberOfMatch) {
        System.out.println(message + numberOfMatch + "개");
    }

    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }
}



