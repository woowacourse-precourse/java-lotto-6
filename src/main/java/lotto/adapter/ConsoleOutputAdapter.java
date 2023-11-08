package lotto.adapter;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Rank;
import lotto.domain.RankInfo;
import lotto.port.OutputPort;

public class ConsoleOutputAdapter implements OutputPort {
    private static final String OUTPUT_PURCHASE_AMOUNT = "%d개를 구매했습니다.";
    private static final String OUTPUT_RANK_STATISTICS_START = "당첨 통계\n---";
    private static final String OUTPUT_RANK_STATISTICS = "%s개 일치%s (%s원) - %d개";

    private static final String OUTPUT_BONUS_NUMBER = "총 수익률은 %f.2입니다.";

    public void printLottos(List<Lotto> lottos) {
        System.out.println(String.format(OUTPUT_PURCHASE_AMOUNT, lottos.size()));

        for (Lotto lotto : lottos) {
            System.out.println(String.format("[%s]", lotto.getNumbers().stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(", "))));
        }
    }

    public void printRankStatistics(List<RankInfo> rankInfos) {
        System.out.println(OUTPUT_RANK_STATISTICS_START);

        for (RankInfo rankInfo : rankInfos) {
            String bonusDescription = "";
            if (rankInfo.getRank().isMatchBonus()) {
                bonusDescription += ", 보너스 볼 일치";
            }

            System.out.println(
                    String.format(
                            OUTPUT_RANK_STATISTICS,
                            rankInfo.getRank().getMatchBallCount(), bonusDescription,
                            rankInfo.getRank().getPrizeByWon(),
                            rankInfo.getCount()));
        }
    }

    public void printProfitRate(Double profitRate) {
        System.out.println(String.format(OUTPUT_BONUS_NUMBER, profitRate));
    }

}
