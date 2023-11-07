package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.domain.Rank;

public class OutputView {

    private static final String PURCHASE_MESSAGE = "\n%d개를 구매했습니다.\n";
    private static final String PROFIT_MESSAGE = "총 수익률은 %s%%입니다.";
    private static final String LOTTO_STATISTICS_MESSAGE = "\n당첨 통계\n---";

    private static final String RESULT_FORMAT = "%s - %d개%n";

    public void print(List<Lotto> lottoTickets) {
        printCountOf(lottoTickets);
        lottoTickets.forEach(System.out::println);
    }

    private void printCountOf(List<Lotto> lottoTickets) {
        System.out.printf(PURCHASE_MESSAGE, lottoTickets.size());
    }

    public void printResult(LottoResult lottoResult) {
        System.out.println(LOTTO_STATISTICS_MESSAGE);

        Map<Rank, Integer> results = lottoResult.getResult();

        String resultString = Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.NOTHING)
                .map(rank -> String.format(RESULT_FORMAT, rank.toString(), results.getOrDefault(rank, 0)))
                .collect(Collectors.joining());

        System.out.print(resultString);
    }

    public void printProfit(Profit profit) {
        System.out.printf(PROFIT_MESSAGE, profit);
    }

    public void printError(String message) {
        System.out.println(message);
    }
}