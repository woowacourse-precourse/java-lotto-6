package lotto.view;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Profit;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String LOTTO_STATISTICS_MESSAGE = "\n당첨 통계\n---";

    public void print(List<Lotto> lottoTickets) {
        printCountOf(lottoTickets);
        lottoTickets.forEach(System.out::println);
    }

    private void printCountOf(List<Lotto> lottoTickets) {
        System.out.printf(PURCHASE_MESSAGE, lottoTickets.size());
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println(LOTTO_STATISTICS_MESSAGE);
        System.out.print(lottoResult.toString());
    }

    public void printProfit(Profit profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }
}