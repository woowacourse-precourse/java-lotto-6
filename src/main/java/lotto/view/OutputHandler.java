package lotto.view;

import java.text.NumberFormat;
import java.util.List;
import lotto.service.LotteryStatistics;
import lotto.model.Prize;

public class OutputHandler {

    public static void outputPurchaseAmount(int amount) {
        System.out.println("\n"+ amount / 1000 + "개를 구매했습니다.");
    }

    public static void printWinningResult(List<List<Integer>> userLottoList, List<Integer> winningNums) {
        int totalEarnings = LotteryStatistics.calculateTotalEarnings(userLottoList, winningNums);
        int[] winningCounts = LotteryStatistics.countWinningCounts(userLottoList, winningNums);

        printWinningStats(winningCounts);
        printEarningRate(totalEarnings, userLottoList.size());
    }

    public static void printWinningStats(int[] winningCounts) {
        System.out.println("\n당첨 통계\n---");

        for (int i = 4; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            String prizeDesc = getPrizeDescription(prize);
            System.out.println(prizeDesc + " (" +
                    NumberFormat.getInstance().format(prize.getPrizeMoney()) + "원) - " + winningCounts[4 - i] + "개");
        }
    }

    public static String getPrizeDescription(Prize prize) {
        return (prize == Prize.SECOND) ?
                prize.getMatchedCount() + "개 일치, 보너스 볼 일치" :
                prize.getMatchedCount() + "개 일치";
    }

    public static void printEarningRate(int totalEarnings, int ticketCount) {
        double earningRate = (totalEarnings / (double) (ticketCount * 1000)) * 100;
        System.out.println("총 수익률은 " + NumberFormat.getInstance().format(earningRate) + "%입니다.");
    }
}
