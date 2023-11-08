package lotto.view;

import static lotto.model.Ranking.*;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Ranking;

public class OutputView {
    private static final String PRINT_TICKET_COUNT = "\n%d개를 구매했습니다.\n";
    private static final String PRINT_WINNING_STATISTICS = "\n당첨 통계\n---";
    private static final String PRICE_FORMAT = "#,###";
    private static final String PRINT_RATE_OF_RETURN = "\n총 수익률은 %.1f%%입니다.";

    public void printPurchases(int ticketCount) {
        System.out.printf(PRINT_TICKET_COUNT, ticketCount);
    }

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for(Lotto lotto : issuedLotto) {
            String result = Arrays.toString(lotto.getNumbers().toArray());
            System.out.println(result);
        }
    }

    public void printLotteryStatistics() {
        System.out.println(PRINT_WINNING_STATISTICS);
    }

    public void printStatisticsResult(Map<Ranking, Integer> results) {
        getAllRankingCase().stream()
            .filter(ranking -> ranking != NOTHING)
            .forEach(ranking -> System.out.printf(
                ranking.getMessage(),
                ranking.getMatchedCount(),
                transfer(ranking.getAmount()),
                results.get(ranking)
            ));
    }

    private String transfer(int price) {
        DecimalFormat decimalFormat = new DecimalFormat(PRICE_FORMAT);
        return decimalFormat.format(price);
    }

    public void printRateOfReturn(float result) {
        System.out.printf(PRINT_RATE_OF_RETURN, result);
    }
}
