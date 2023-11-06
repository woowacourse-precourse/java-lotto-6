package lotto.View;

import java.util.List;
import lotto.Domain.Lotto;

public class OutputView {

    private static final String LOTTO_AMOUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_RESULT_MESSAGE = "당첨 통계";
    private static final String LINE_MESSAGE = "---";
    private static final int MIN_MATCHING_COUNT = 3;
    private static final int MAX_MATCHING_COUNT = 6;

    public static void printLottoAmount(int purchasedAmount) {

        System.out.println(purchasedAmount + LOTTO_AMOUNT_MESSAGE);
    }

    public static void printPurchasedLottoList(List<Lotto> lottoList) {

        for (Lotto lotto : lottoList) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
    }

/*    public static void printMatchingCounts(int[] matchCounts) {
        System.out.println(WINNING_RESULT_MESSAGE);
        System.out.println(LINE_MESSAGE);

        boolean hasBonus = matchCounts[MAX_MATCHING_COUNT] > 0;

        for (int i = MIN_MATCHING_COUNT; i <= MAX_MATCHING_COUNT; i++) {
            int matchCount = matchCounts[i];
            String prizeDescription = getPrizeDescription(i, hasBonus);
            System.out.println(prizeDescription + " - " + matchCount + "개");
        }
    }*/

   public static void printMatchingCounts (int[] winningConunts, int totalPurchasAmount) {
        System.out.println("당첨 통계\n---");

        System.out.printf("3개 일치 (5,000원) - %d개\n" , winningConunts[3]);
        System.out.printf("4개 일치 (50,000원) - %d개\n" , winningConunts[4]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n" , winningConunts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n" , winningConunts[7]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n" , winningConunts[6]);
        System.out.printf("총 수익률은 %.1f",
                (float)(winningConunts[3]*5000+winningConunts[4]*50000+winningConunts[5]*1500000+winningConunts[7]*30000000+winningConunts[6]*2000000000)/totalPurchasAmount);
        System.out.print("%입니다.");
    }
/*
    public static void printProfitRate(double profitRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", profitRate) + "%입니다.");
    }*/
}



