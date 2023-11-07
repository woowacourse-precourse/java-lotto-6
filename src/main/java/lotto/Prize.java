package lotto;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Prize {
    private static int bonusCounts;
    private static int luckyCounts;
    private static int totalProfit;
    private static List<Integer> separatedLotto = new ArrayList<Integer>();
    private static final int[] finalResult = new int[5];
    private static final int LOOP_INITIALIZATION = 0;

    static void separateNumbers() {
        for (int i = 0; i < Issue.lottoGroup.size(); i++) {
            separatedLotto = Issue.lottoGroup.get(i);
            luckyCounts = LOOP_INITIALIZATION;
            bonusCounts = LOOP_INITIALIZATION;

            checkNumbers();
            winPrize();
        }
    }

    static void checkNumbers() {
        for (int j = 0; j < separatedLotto.size(); j++) {
            if (separatedLotto.contains(Pick.luckyNumber.get(j))) {
                luckyCounts += 1;
            }

            if (separatedLotto.contains((Pick.bonusNumber))) {
                bonusCounts += 1;
            }
        }
    }

    static void winPrize() {
        if (luckyCounts == 6) {
            finalResult[0] += 1;
        }

        else if (luckyCounts == 5 && bonusCounts == 1) {
            finalResult[1] += 1;
        }

        else if (luckyCounts == 5 && bonusCounts == 0) {
            finalResult[2] += 1;
        }

        else if (luckyCounts == 4) {
            finalResult[3] += 1;
        }

        else if (luckyCounts == 3) {
            finalResult[4] += 1;
        }
    }

    static void printPrize() {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + finalResult[4] + "개");
        System.out.println("4개 일치 (50,000원) - " + finalResult[3] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + finalResult[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + finalResult[1] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + finalResult[0] + "개");
    }

    static void calculateProfit() {
        if (finalResult[0] >= 1) {
            totalProfit = totalProfit + (finalResult[0] * 2_000_000_000);
        }

        if (finalResult[1] >= 1) {
            totalProfit = totalProfit + (finalResult[1] * 30_000_000);
        }

        if (finalResult[2] >= 1) {
            totalProfit = totalProfit + (finalResult[2] * 1_500_000);
        }

        if (finalResult[3] >= 1) {
            totalProfit = totalProfit + (finalResult[3] * 50_000);
        }

        if (finalResult[4] >= 1) {
            totalProfit = totalProfit + (finalResult[4] * 5_000);
        }
    }

    static void printProfitRate() {
        double initialProfitRate = (double) totalProfit / Issue.initialCash * 100;
        DecimalFormat rateFormat = new DecimalFormat("###,##0.0");
        String profitRate = rateFormat.format(initialProfitRate);
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    public static void playPrize() {
        separateNumbers();
        printPrize();
        calculateProfit();
        printProfitRate();
    }
}
