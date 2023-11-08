package lotto.view;


import lotto.model.LottoResult;

import java.text.DecimalFormat;
import java.util.Collections;
import java.util.List;

public class OutputView {
    public static void printPurchaseAmountInputMessage() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printLottoCountMessage(Integer lottoCount) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottoCount);
    }

    public static void printLottoBatch(List<String> lottoBatch) {
        lottoBatch.forEach(lotto -> System.out.println(lotto));
        System.out.println();
    }

    public static void printWinningNumbersInputMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void printBonusNumberInputMessage() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
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
        DecimalFormat formatter = new DecimalFormat("###,###");
        int[] lottoResultCounts = countLottoResult(lottoResults);

        System.out.println("\n당첨 통계");
        System.out.println("---");
        for (int i = 0; i < lottoResultCounts.length; i++) {
            LottoResult lottoResult = LottoResult.findByIndex(i);
            if (lottoResult.matchedBonusNumber()) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", lottoResult.getMatchedWinningNumberCount(), formatter.format(lottoResult.getPrizeMoney()), lottoResultCounts[i]);
                continue;

            }
            System.out.printf("%d개 일치 (%s원) - %d개\n", lottoResult.getMatchedWinningNumberCount(), formatter.format(lottoResult.getPrizeMoney()), lottoResultCounts[i]);
        }
    }

    public static void printLottoProfitRate(Float lottoProfitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", lottoProfitRate);
    }


}