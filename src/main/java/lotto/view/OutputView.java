package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.Statistic;
import lotto.util.Util;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final int PERCENTAGE_MULTIPLIER = 100;
    public static void purchaseLottoMessage(int purchasableLotto) {
        System.out.println(purchasableLotto+"개를 구매했습니다.");
    }

    public static void lottoNumberMessage(List<Lotto> lottoTickets) {
        for (Lotto lotto: lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
        lineBreakMessage();
    }

    public static void lineBreakMessage() {
        System.out.println();
    }

    public static void lottoResultMessage(Statistic statistic, int money) {
        System.out.println("당첨 통계");
        System.out.println("---");

        rankResultMessage(statistic.getLottoRankCount());
        earnResultMessage(statistic.getLottoEarnings(),money);

    }

    public static void rankResultMessage(Map<LottoRank, Integer> lottoRankCount) {
        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.LOSE) {
                continue;
            }
            if (rank == LottoRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n",
                        rank.getMatch(),
                        lottoRankCount.get(rank));
                continue;
            }
            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    rank.getMatch(),
                    Util.intToString(rank.getPrize()),
                            lottoRankCount.get(rank));
        }
    }

    public static void earnResultMessage(int lottoEarning, int money) {
        System.out.printf("총 수익률은 %.1f%%입니다.%n", (float) lottoEarning/money*PERCENTAGE_MULTIPLIER);
    }
}
