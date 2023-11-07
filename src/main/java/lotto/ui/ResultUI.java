package lotto.ui;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;

/**
 * @author 민경수
 * @description result ui
 * @since 2023.11.05
 **********************************************************************************************************************/
public class ResultUI {

    // TODO 계산등의 기능을 분리 시켜야 함
    public void printBoughtLottos(LottoTickets lottos) {
        StringBuilder sb = new StringBuilder();

        String purchaseMsg = String.format("%d개를 구매했습니다.", lottos.size());
        sb.append(purchaseMsg).append(System.lineSeparator());

        lottos.labelNumbers((numbers) -> sb.append(numbers).append(System.lineSeparator()));

        System.out.println(sb);
    }

    public void printStatistics(Map<LottoPrize, Integer> countOfWinningRanks, LottoTickets boughtLottos) {
        StringBuilder sb = new StringBuilder();

        appendHeader(sb);
        appendStatistics(countOfWinningRanks, sb);
        appendProfitRate(countOfWinningRanks, sb, boughtLottos);

        System.out.println(sb.toString());
    }

    private void appendProfitRate(Map<LottoPrize, Integer> countOfWinningRanks, StringBuilder sb,
                                  LottoTickets boughtLottos) {
        sb.append("총 수익률은 ").append(getProfitRate(countOfWinningRanks, boughtLottos)).append("%입니다.");
    }

    private String getProfitRate(Map<LottoPrize, Integer> countOfWinningRanks, LottoTickets boughtLottos) {
        BigDecimal result = BigDecimal.valueOf(0);

        for (LottoPrize lottoPrize : countOfWinningRanks.keySet()) {
            result = result.add(BigDecimal.valueOf(lottoPrize.amount() * countOfWinningRanks.get(lottoPrize)));
        }

        BigDecimal rate = result.divide(boughtLottos.totalPurchasedAmount(), 3, RoundingMode.HALF_UP).multiply(BigDecimal.valueOf(100));

        return String.format("%.1f", rate);
    }

    private BigDecimal getTotalProfit(Map<LottoPrize, Integer> countOfWinningRanks) {
        BigDecimal result = BigDecimal.ZERO;
        for (LottoPrize lottoPrize : countOfWinningRanks.keySet()) {
            result = result.add(BigDecimal.valueOf(lottoPrize.amount() * countOfWinningRanks.get(lottoPrize)));
        }

        return result;
    }

    private void appendHeader(StringBuilder sb) {
        sb.append("당첨 통계").append(System.lineSeparator());
        sb.append("---------").append(System.lineSeparator());
    }

    private void appendStatistics(Map<LottoPrize, Integer> countOfWinningRanks, StringBuilder sb) {
        Set<LottoPrize> winningRanks = EnumSet.allOf(LottoPrize.class);
        winningRanks.stream()
                .filter(r -> r.amount() > 0)
                .map(r -> getStatisticFrom(countOfWinningRanks, r))
                .forEach(s -> sb.append(s).append(System.lineSeparator()));
    }

    private String getStatisticFrom(Map<LottoPrize, Integer> countOfWinningRanks, LottoPrize winningRank) {
        return String.format("%s개 일치%s (%,d원) - %d개",
                winningRank.matchingCount(),
                winningRank.bonusBallMatchRequired() ? ", 보너스 볼 일치" : "",
                winningRank.amount(),
                countOfWinningRanks.getOrDefault(winningRank, 0));
    }

}