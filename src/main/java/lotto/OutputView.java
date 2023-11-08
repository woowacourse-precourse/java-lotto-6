package lotto;

import java.util.List;

public class OutputView {
    static int lottoPurchaseCount;

    static void printProfitRate(long totalPrizeMoney) {
        System.out.printf("총 수익률은 %.1f%%입니다.",
                (float) totalPrizeMoney * 100 / (Integer.parseInt(LottoPurchaseInput.lottoPurchaseAmount)));

    }

    static void printLottoGameStatics() {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", CompareWinnerNum.Match_3_Count);
        System.out.printf("4개 일치 (50,000원) - %d개%n", CompareWinnerNum.Match_4_Count);
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", CompareWinnerNum.Match_5_Count);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", CompareWinnerNum.Match_5_AndBonusCount);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", CompareWinnerNum.Match_6_Count);

    }

    static void printPurchaseCount(String lottoPurchaseAmount) {
        lottoPurchaseCount = Integer.parseInt(lottoPurchaseAmount) / 1000;
        System.out.printf("%n%d개를 구매했습니다.%n", lottoPurchaseCount);
    }

    static void printLottoNumbers(List<Integer> lottoNumbersDrawn) {
        System.out.println(lottoNumbersDrawn);
    }
}

