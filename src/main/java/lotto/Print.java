package lotto;

import java.util.ArrayList;
import java.util.List;

public class Print {

    public void printLottoCount(int purchaseCount) {
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
    }


    public void printLottos(List<List<Integer>> lottos) {
        for (var lotto : lottos) {
            System.out.println(lotto);
        }
    }


    public void printWinStatistic() {
        for (WinningRankPrize rankPlace : WinningRankPrize.values()) {
            System.out.printf(rankPlace.getMatchCount() + " (%s원) - %d개%n", rankPlace.getPrizeAmount(), rankPlace.getWinCount());
        }
    }


    public void printRateOfReturn(int purchaseAmount) {
        float rateOfReturn;
        Process endProcess = new Process();

        rateOfReturn = endProcess.calculateRateOfReturn(purchaseAmount);

        System.out.printf("총 수익률은 %.1f%%입니다.", rateOfReturn);
    }


}
