package lotto.view;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import lotto.domain.PurchasedLottos;
import lotto.domain.Rank;
import lotto.dto.LottoMatchResultDto;

public class OutputView {
    private static final String DIVIDER = "---";
    private static final String RESULT_HEADER_MESSAGE = "당첨 통계";
    private static final String DELIMITER = ", ";
    private static final String PREFIX = "[";
    private static final String SUFFIX = "]";
    private static final String PURCHASED_LOTTOS_COUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String LOTTO_STATISTIC_FORMAT = "%d개 일치 (%,d원) - %d개";
    private static final String LOTTO_STATISTIC_FORMAT2 = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
    private static final String PROFITRATE_MESSAGE = "총 수익률은 %.1f%%입니다.\n";

    public void outputPurchasedLottos(PurchasedLottos purchasedLottos) {
        outputPurchasedLottosCount(purchasedLottos);

        purchasedLottos.getCurrentPurchasedLottosList()
                .stream()
                .map(lotto -> lotto.stream().collect(Collectors.joining(DELIMITER, PREFIX, SUFFIX)))
                .forEach(System.out::println);
    }

    public void outputPurchasedLottosCount(PurchasedLottos purchasedLottos) {
        System.out.printf(PURCHASED_LOTTOS_COUNT_MESSAGE, purchasedLottos.purchasedLottosCount());
    }

    public void outputLottoMatchResult(LottoMatchResultDto lottoMatchResultDto) {
        outputLottoStatisticPreinput();
        outputLottoStatistic(lottoMatchResultDto);
        outputProfitRate(lottoMatchResultDto);
    }

    private void outputProfitRate(LottoMatchResultDto lottoMatchResultDto) {
        System.out.printf(PROFITRATE_MESSAGE, lottoMatchResultDto.getProfitRate());
    }

    private void outputLottoStatistic(LottoMatchResultDto lottoMatchResultDto) {
        lottoMatchResultDto.getLottoRankCount()
                .entrySet()
                .stream()
                .filter(lottoRankIntegerEntry -> lottoRankIntegerEntry.getKey() != Rank.NONE)
                .sorted(Comparator.comparing((Map.Entry<Rank, Integer> entry) -> entry.getKey().getPrize()))
                .forEach(matchResult -> System.out.println(formatLottoStatistic(matchResult)));
    }

    private String formatLottoStatistic(Map.Entry<Rank, Integer> entry) {
        Rank rank = entry.getKey();
        int ticketCount = entry.getValue();

        String printFormat = LOTTO_STATISTIC_FORMAT;
        if (rank == Rank.SECOND) {
            printFormat = LOTTO_STATISTIC_FORMAT2;
        }
        return String.format(printFormat, rank.getMatchCount(), rank.getPrize(), ticketCount);
    }

    private void outputLottoStatisticPreinput() {
        System.out.println(RESULT_HEADER_MESSAGE);
        System.out.println(DIVIDER);
    }
}
