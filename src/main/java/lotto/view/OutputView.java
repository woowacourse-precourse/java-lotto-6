package lotto.view;

import lotto.domain.*;

import java.util.Arrays;
import java.util.List;

public class OutputView {
    public static void printBuyLotto(Money money) {
        System.out.printf("%d개를 구매했습니다.\n", money.getTicket());
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printRankReuslt(RankResult rankResult) {
        System.out.println("당첨 통계\n---");
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.EMPTY))
                .forEach(rank -> System.out.println(getPrintResult(rank, rankResult)));
    }

    private static String getPrintResult(Rank rank, RankResult rankResult) {
        if(rank == Rank.SECOND) {
            return String.format("%d개 일치, 보너스 볼 일치 (%s원) - %d개"
                    , rank.getMatchLottoCnt()
                    , String.format("%,d", rank.getMoney())
                    , rankResult.getRankResultCnt(rank));
        }
        return String.format("%d개 일치 (%s원) - %d개"
                , rank.getMatchLottoCnt()
                , String.format("%,d", rank.getMoney())
                , rankResult.getRankResultCnt(rank));
    }

    public static void printBenefitRate(BenefitRate benefitRate) {
        System.out.printf("총 수익률은 %.1f%%입니다.\n", benefitRate.getBenefit());
    }
}
