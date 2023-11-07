package lotto.view;

import lotto.Lotto;

import java.util.List;

import lotto.domain.Rank;
import lotto.domain.RankContainer;
import main.java.lotto.domain.WinningLottos;
public class SystemOutput {

    public static void printPurchaseAmount(int purchaseAmount) {
        String OUTPUT_MESSAGE = "%d개를 구매했습니다.";

        System.out.printf((OUTPUT_MESSAGE) + "%n", (purchaseAmount / 1000));
    }

    public static void printWiningLotto(WinningLottos winningLottos) {
        List<Lotto> winningLottoGroup = winningLottos.getWiningLottos();
        for (Lotto lotto : winningLottoGroup) {
            System.out.println(lotto);
        }
    }

    public static void printRankResult(RankContainer rankContainer, double rate) {
        System.out.println("당첨 통계" + "\n" + "---");
        for (Rank rank : Rank.values()) {
            if (!rank.equals(Rank.NONE)) {
                System.out.println(getRankContainerResult(rank, rankContainer));
            }
        }
        System.out.printf(("총 수익률은 %.1f%%입니다.") + "\n", rate);
    }

    public static String getRankContainerResult(Rank rank, RankContainer rankContainer) {
        if (rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개", rank.getCount(), String.format("%,d", rank.getAward()), rankContainer.getRankContainer(rank));
        }

        return String.format("%d개 일치 (%s원) - %d개", rank.getCount(), String.format("%,d", rank.getAward()), rankContainer.getRankContainer(rank));
    }




}
