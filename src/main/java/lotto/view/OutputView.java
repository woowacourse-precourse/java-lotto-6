package lotto.view;

import java.text.NumberFormat;
import java.util.Collection;
import java.util.Locale;
import java.util.Map;
import lotto.domain.EarningRate;
import lotto.domain.LottoCheckResult;
import lotto.domain.WinningStatus;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoTickets;

public class OutputView {

    public void printLotto(LottoTickets lottoTickets) {
        Collection<Lotto> tickets = lottoTickets.getLottoTickets();

        System.out.printf("\n%d개를 구매했습니다.\n", tickets.size());

        tickets.stream()
                .map(Lotto::getLotto)
                .forEach(lotto -> System.out.println(lotto));
    }

    public void printResult(LottoCheckResult lottoCheckResult, EarningRate earningRate) {
        System.out.println("\n당첨 통계\n---");

        Map<WinningStatus, Integer> result = lottoCheckResult.getResult();

        Locale locale = new Locale("ko", "KR");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

        for (Map.Entry<WinningStatus, Integer> entry : result.entrySet()) {
            if (entry.getKey().getMatchCount() == 0) continue;
            if (entry.getKey() == WinningStatus.FIVE_MATCH_WITH_BONUS) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n", entry.getKey().getMatchCount(), formatter.format(entry.getKey().getPrize()).substring(1), entry.getValue());
            } else if (entry.getKey() != WinningStatus.FIVE_MATCH_WITH_BONUS) {
                System.out.printf("%d개 일치 (%s원) - %d개\n", entry.getKey().getMatchCount(), formatter.format(entry.getKey().getPrize()).substring(1), entry.getValue());
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.", earningRate.getRate());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
