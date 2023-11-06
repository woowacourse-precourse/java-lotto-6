package lotto.view;

import static lotto.domain.PrintMessages.*;
import static lotto.util.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoRank;
import lotto.domain.LottoResults;
import lotto.domain.Lottos;

public class ConsoleOutputView implements Output {

    @Override
    public void displayInputRequest(String announce) {
        System.out.println(announce);
    }

    @Override
    public void printWinningStatistics(LottoResults winningStatistics) {
        Map<LottoRank, Integer> result = winningStatistics.rankCounts();
        System.out.println(WINNING_STATISTICS_ANNOUNCE.getMessage());
        Arrays.stream(LottoRank.values())
                .forEach(rank -> {
                    int count = result.getOrDefault(rank, 0);
                    System.out.printf("%s - %d개\n", rank.getDescription(), count);
                });
    }

    @Override
    public void printTotalEarningsRate(double earningsRate) {
        System.out.printf(TOTAL_EARNINGS_RATE.getFormattedEarningRate(earningsRate));
    }

    @Override
    public void printError(String errorMessage) {
        System.out.println(ERROR_PREFIX + errorMessage);
    }


    @Override
    public void printPurchasedLottos(Lottos lottos) {
        List<Lotto> allLotto = lottos.getLottos();
        System.out.println(allLotto.size() + PURCHASED_LOTTOS_COUNT.getMessage());
        allLotto.forEach(lotto -> System.out.println(formatLottoNumbers(lotto)));
    }

    private String formatLottoNumbers(Lotto lotto) {
        return lotto.getNumbers().stream()
                .map(LottoNumber::getNumber)
                .map(String::valueOf)
                .collect(Collectors.joining(
                        COMMA.getValue(),
                        LIST_PREFIX.getValue(),
                        LIST_SUFFIX.getValue()));
    }
}
