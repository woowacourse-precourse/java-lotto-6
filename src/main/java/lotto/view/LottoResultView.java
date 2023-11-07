package lotto.view;

import lotto.model.LottoPrize;

import java.util.List;

public class LottoResultView {
    public void printResultLog(int[] prizeLog) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", prizeLog[5]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", prizeLog[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", prizeLog[3]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", prizeLog[2]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", prizeLog[1]);
    }

    public void printRateOfReturn(List<LottoPrize> lottoPrizes, int price) {
        long totalPrize = calcTotalPrize(lottoPrizes);
        double rateOfReturn = (double) totalPrize / price * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", rateOfReturn);
    }

    private long calcTotalPrize(List<LottoPrize> lottoPrizes) {
        long totalPrize = 0;
        for (LottoPrize info : lottoPrizes) {
            totalPrize += info.getPrize();
        }
        return totalPrize;
    }
}
