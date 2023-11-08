package lotto.view;

import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Ranking;

import java.util.Arrays;

public class OutputView {

    private static final String LOTTO_COUNT_MESSAGE = "%,d개를 구매했습니다.";

    private static final String LOTTO_RESULT_MESSAGE = "당첨 통계";
    private static final String LOTTO_RESULT_DIVIDER = "---";
    private static final String LOTTO_RANKING_FORMAT = "%d개 일치 (%,d원) - %,d개";
    private static final String LOTTO_BONUS_RANKING_FORMAT = "%d개 일치, 보너스 볼 일치 (%,d원) - %,d개";

    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %,.1f%%입니다.";

    public void printLottos(Lottos lottos) {
        System.out.println(String.format(LOTTO_COUNT_MESSAGE, lottos.size()));
        System.out.println(lottos);
        System.out.println();
    }

    public void printLottoResult(LottoResult lottoResult) {
        System.out.println(LOTTO_RESULT_MESSAGE);
        System.out.println(LOTTO_RESULT_DIVIDER);
        printRankingResult(lottoResult);
        printRate(lottoResult);
        System.out.println();
    }

    private void printRankingResult(LottoResult lottoResult) {
        Arrays.stream(Ranking.values())
                .filter(ranking -> ranking != Ranking.NONE)
                .forEach(ranking -> printRanking(lottoResult, ranking));
    }

    private void printRate(LottoResult lottoResult) {
        System.out.printf((PROFIT_RATE_MESSAGE) + "%n", lottoResult.getProfitRate());
    }

    private void printRanking(LottoResult lottoResult, Ranking ranking) {
        if (ranking == Ranking.SECOND) {
            System.out.println(
                    String.format(
                            LOTTO_BONUS_RANKING_FORMAT,
                            ranking.getMatchNumberCount(),
                            ranking.getMoney(),
                            lottoResult.get(ranking)));
            return;
        }
        System.out.println(
                String.format(
                        LOTTO_RANKING_FORMAT,
                        ranking.getMatchNumberCount(),
                        ranking.getMoney(),
                        lottoResult.get(ranking)));
    }
}
