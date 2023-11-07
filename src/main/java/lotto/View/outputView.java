package lotto.View;

import java.util.List;
import lotto.Model.Lotto;

public class outputView {
    public static void displayLottoCount(int count){
        System.out.println(count+"개를 구매했습니다.");
    }

    public void displayLottoNumberList(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }

    public void displayLottoResult(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] winningCounts = new int[6];
        for (Lotto lotto : purchasedLottos) {
            int count = Lotto.getWinningNumberCount(winningNumbers, lotto.getNumbers());
            boolean bonuscount = Lotto.isMatchBonusNumber(winningNumbers,bonusNumber);
            if(bonuscount){
                count+=1;
            }
            if(count == 3) winningCounts[0] ++;
            if(count == 4) winningCounts[1] ++;
            if(count == 5) winningCounts[2] ++;
            if(count == 6 && bonuscount) winningCounts[3] ++;
            if(count==6 && !bonuscount) winningCounts[4] ++;

        }

        int totalPrize = calculateTotalPrize(winningCounts);
        double profitRate = calculateProfitRate(totalPrize, purchasedLottos.size() * 1000);

        System.out.println("3개 일치 (5,000원) - " + winningCounts[0] + "개");
        System.out.println("4개 일치 (50,000원) - " + winningCounts[1] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + winningCounts[2] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + winningCounts[3] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + winningCounts[4] + "개");
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }

    private int calculateTotalPrize(int[] winningCounts) {
        int totalPrize = 0;
        totalPrize += winningCounts[0] * 5000;
        totalPrize += winningCounts[1] * 50000;
        totalPrize += winningCounts[2] * 1500000;
        totalPrize += winningCounts[3] * 30000000;
        totalPrize += winningCounts[4] * 2000000000;
        return totalPrize;
    }

    private double calculateProfitRate(int totalPrize, int totalCost) {
        if (totalCost == 0) {
            return 0.0;
        }
        return 100 + ((totalPrize - totalCost) / (double) totalCost * 100.0);
    }

}
