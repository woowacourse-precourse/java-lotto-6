package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

public class MessageResolver {

    public String resolvePurchasedInformationMessage(List<Lotto> lottos) {
        StringBuilder message = new StringBuilder();

        message.append(String.format("\n%d개를 구매했습니다.\n", lottos.size()));
        lottos.stream()
                .map(Lotto::mapToIntegers)
                .forEach(numbers -> {
                    message.append(numbers)
                            .append("\n");
                });
        return message.toString();
    }

    public String resolveResultMessage(LottoResult result) {
        StringBuilder message = new StringBuilder();
        System.out.println("\n당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoRank.values())
                .filter(rank -> !rank.equals(LottoRank.NONE))
                .forEach(rank -> {
                    message.append(rank.getMatchingCount())
                            .append("개 일치");
                    if (rank == LottoRank.SECOND) {
                        message.append(", 보너스 볼 일치");
                    }
                    message.append(" (")
                            .append(formatPrize(rank.getPrize()))
                            .append(") - ")
                            .append(result.getCountByRank(rank))
                            .append("개\n");
                });

        return message.toString();
    }

    public String resolveProfitRateMessage(double profitRate) {
        return String.format("총 수익률은 %.1f%%입니다", profitRate);
    }

    private String formatPrize(long prize) {
        return String.format("%,d원", prize);
    }
}
