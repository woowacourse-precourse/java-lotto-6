package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.RankResult;

import java.util.Arrays;

public class OutputView {
    private static final String TICKET_COUNT = "%d개를 구매했습니다.";
    private static final String RESULT_TOP_MESSAGE = "당첨 통계" + "\n" + "---";
    private static final String RANK_RESULT_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String RANK_SECOND_RESULT_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public static void printBuyLotto(Money money) {
        System.out.printf((TICKET_COUNT) + "%n", money.getTicket());
    }

    public static void printLottos(Lottos lottos) {
        lottos.getLottos().forEach(System.out::println);
        System.out.println();
    }

    public static void printResult(RankResult rankResult) {
        System.out.println(RESULT_TOP_MESSAGE);
        Arrays.stream(Rank.values())
                .filter(rank -> !rank.equals(Rank.NONE))
                .forEach(rank -> System.out.println(getRankResult(rank, rankResult)));
    }

    private static String getRankResult(Rank rank, RankResult rankResult) {
        if (rank == Rank.SECOND) {
            return String.format(RANK_SECOND_RESULT_MESSAGE,
                    rank.getMatchLottoNumber(),
                    String.format("%,d", rank.getPrizeAmount()),
                    rankResult.getRankCount(rank));
        }
        return String.format(RANK_RESULT_MESSAGE,
                rank.getMatchLottoNumber(),
                String.format("%,d", rank.getPrizeAmount()),
                rankResult.getRankCount(rank));
    }
}
