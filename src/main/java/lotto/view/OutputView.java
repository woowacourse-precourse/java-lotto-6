package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.repository.LottoRepository;

public class OutputView {
    public static void printLottos() {
        StringBuilder sb = new StringBuilder();
        List<Lotto> lottos = LottoRepository.getLottos();

        sb.append('\n').append(lottos.size() + "개를 구매했습니다.\n");
        for (int i = 0; i < lottos.size(); i++) {
            Lotto lotto = lottos.get(i);
            sb.append(lotto).append('\n');
        }
        System.out.print(sb);
    }

    public static void printStats(Map<Ranking, Integer> winningResult, double rateOfReturn) {
        System.out.println("\n당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", winningResult.get(Ranking.FIFTH_PLACE));
        System.out.printf("4개 일치 (50,000원) - %d개\n", winningResult.get(Ranking.FOURTH_PLACE));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", winningResult.get(Ranking.THIRD_PLACE));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", winningResult.get(Ranking.SECOND_PLACE));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", winningResult.get(Ranking.FIRST_PLACE));
        System.out.printf("총 수익률은 %.1f%%입니다.\n", rateOfReturn);
    }
}
