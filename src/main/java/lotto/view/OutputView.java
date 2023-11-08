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

    public void outputPurchasedLottos(PurchasedLottos purchasedLottos) {
        outputPurchasedLottosCount(purchasedLottos);

        purchasedLottos.getCurrentPurchasedLottosList()
                .stream()
                .map(lotto -> lotto.stream().collect(Collectors.joining(",", "[","]")))
                .forEach(System.out::println);
    }

    public static void printResult(Map<Rank, Integer> result, double yield) {
        StringBuilder stringBuilder = new StringBuilder();
        appendResultHeaderToStringBuilder(stringBuilder);
        System.out.print(stringBuilder);
        printYield(yield);
    }


    private static void appendResultHeaderToStringBuilder(StringBuilder stringBuilder) {
        stringBuilder.append(RESULT_HEADER_MESSAGE)
                .append(System.lineSeparator())
                .append(DIVIDER)
                .append(System.lineSeparator());
    }

    private static void printYield(double yield) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("총 수익률은 ")
                .append(yield)
                .append("입니다.");
    }

    public void outputPurchasedLottosCount(PurchasedLottos purchasedLottos) {
        System.out.printf("%d개를 구매했습니다.%n", purchasedLottos.purchasedLottosCount());
    }

    public void outputLottoMatchResult(LottoMatchResultDto lottoMatchResultDto) {
       outputLottoStatisticPreinput();
       outputLottoStatistic(lottoMatchResultDto);
       outputProfitRate(lottoMatchResultDto);
    }

    private void outputProfitRate(LottoMatchResultDto lottoMatchResultDto) {
        System.out.printf("총 수익률은 %.1ㄹ%%입니다.\n", lottoMatchResultDto.getProfitRate());
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

        String printFormat = "%d개 일치 (%,d원) - %d개";
        if (rank == Rank.SECOND) {
            printFormat = "%d개 일치, 보너스 볼 일치 (%,d원) - %d개";
        }
        return String.format(printFormat, rank.getMatchCount(), rank.getPrize(), ticketCount);
    }

    private void outputLottoStatisticPreinput() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }
}
