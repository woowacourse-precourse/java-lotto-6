package lotto.view;

import java.util.Collection;
import java.util.Map;
import lotto.domain.EarningRate;
import lotto.domain.LottoCheckResult;
import lotto.domain.WinningStatus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;

public class OutputView {

    public void printLotto(LottoTickets lottoTickets) {
        Collection<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.printf("%d개를 구매했습니다.\n", tickets.size());
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getLotto());
        }
    }

    public void printResult(LottoCheckResult lottoCheckResult, EarningRate earningRate) {
        System.out.println("당첨 통계\n---");

        Map<WinningStatus, Integer> result = lottoCheckResult.getResult();

        for (Map.Entry<WinningStatus, Integer> entry : result.entrySet()) {
            if (entry.getKey().getMatchCount() == 0) continue;

            System.out.printf("%d개 일치 (%d원) - %d개\n", entry.getKey().getMatchCount(), entry.getKey().getPrize(), entry.getValue());
        }

        System.out.printf("총 수익률은 %.1f%% 입니다.", earningRate.getRate());
    }
}
