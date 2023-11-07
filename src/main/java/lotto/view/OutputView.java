package lotto.view;

import java.text.NumberFormat;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.LottoMatchResult;
import lotto.LottoMatchResultDto;
import lotto.LottoRank;
import lotto.PurchasedLottos;

public class OutputView {
    private static final String PURCHASED_LOTTOS_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";
    private static final String LOTTO_STATISTIC_HEADER = "당첨 통계";
    private static final String LOTTO_STATISTIC_SEPARATOR = "---";
    private static final String LOTTO_STATISTIC_FORMAT = "%d개 일치 (%s원) - %d개";
    private static final String LOTTO_STATISTIC_SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    public void outputPurchasedLottos(PurchasedLottos purchasedLottos) {
        outputPurchasedLottosCount(purchasedLottos);

        purchasedLottos.getCurrentPurchasedLottosSnapshot()
                .stream()
                .map(lotto -> lotto.stream().collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX)))
                .forEach(System.out::println);
    }

    private void outputPurchasedLottosCount(PurchasedLottos purchasedLottos) {
        System.out.printf(PURCHASED_LOTTOS_COUNT_MESSAGE, purchasedLottos.purchasedLottosCount());
    }

    public void outputLottoMatchResult(LottoMatchResult lottoMatchResult) {
        outputLottoStatisticPrompt();
        outputLottoStatistic(lottoMatchResult.toDto());
        outputProfitRate(lottoMatchResult.toDto());
    }

    private void outputLottoStatisticPrompt() {
        System.out.println(LOTTO_STATISTIC_HEADER);
        System.out.println(LOTTO_STATISTIC_SEPARATOR);
    }

    private void outputLottoStatistic(LottoMatchResultDto lottoMatchResultDto) {
        lottoMatchResultDto.getLottoRankCount()
                .entrySet()
                .stream()
                .filter(lottoRankIntegerEntry -> lottoRankIntegerEntry.getKey() != LottoRank.LOSE)
                .sorted(Comparator.comparing((Map.Entry<LottoRank, Integer> entry) -> entry.getKey().getPrize()))
                .forEach(matchResult -> System.out.println(formatLottoStatistic(matchResult)));
    }

    private String formatLottoStatistic(Map.Entry<LottoRank, Integer> entry) {
        LottoRank rank = entry.getKey();
        int ticketCount = entry.getValue();

        NumberFormat prizeFormat = NumberFormat.getInstance();
        String prize = prizeFormat.format(rank.getPrize());
        String printFormat = LOTTO_STATISTIC_FORMAT;
        if (rank == LottoRank.SECOND) {
            printFormat = LOTTO_STATISTIC_SECOND_RANK_FORMAT;
        }
        return String.format(printFormat, rank.getMatchCount(), prize, ticketCount);
    }

    private void outputProfitRate(LottoMatchResultDto lottoMatchResultDto) {
        System.out.printf(PROFIT_RATE_MESSAGE, lottoMatchResultDto.getProfitRate());
    }
}
