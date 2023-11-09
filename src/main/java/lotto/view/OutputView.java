package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.enums.Prize;
import lotto.model.WinningLotto;

public class OutputView {
    int totalPrize = 0;

    public void showPurchasedLottos(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            System.out.println("[" + lotto.sortNumbers() + "]");
        }
    }
    
    public void showPrizeResult(List<Lotto> lottos, WinningLotto winningLotto, int purchaseAmount) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        int[] matchCounts = new int[Prize.values().length];

        totalPrize = getTotalPrize(lottos, winningLotto, matchCounts, totalPrize);
        printFinalResult(matchCounts);

        double profitRate = (totalPrize / (double) purchaseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    private void printFinalResult(int[] matchCounts) {
        for (int i = Prize.values().length - 1; i >= 0; i--) {
            Prize prize = Prize.values()[i];
            DecimalFormat decFormat = new DecimalFormat("###,###");
            int prizeMatchCount = prize.getMatchCount();
            String prizeMoney = decFormat.format(prize.getPrizeMoney());
            int prizeCount = matchCounts[prize.ordinal()];
            formatResult(prize, prizeMatchCount, prizeMoney, prizeCount);
        }
    }

    private void formatResult(Prize prize, int prizeMatchCount, String prizeMoney, int prizeCount) {
        if (prize != Prize.NONE && prize != Prize.SECOND) {
            System.out.println(prizeMatchCount + "개 일치 (" + prizeMoney + "원) - " + prizeCount + "개");
        }
        if (prize == Prize.SECOND) {
            System.out.println(prizeMatchCount + "개 일치, 보너스 볼 일치 (" + prizeMoney + "원) - " + prizeCount + "개");
        }
    }

    private int getTotalPrize(List<Lotto> lottos, WinningLotto winningLotto, int[] matchCounts, int totalPrize) {
        for (Lotto lotto : lottos) {
            Prize prize = winningLotto.calculatePrize(lotto);
            matchCounts[prize.ordinal()]++;
            totalPrize += prize.getPrizeMoney();
        }
        return totalPrize;
    }
}
