package lotto.ui;

import java.util.EnumSet;
import java.util.Map;
import java.util.Set;
import lotto.domain.LottoPrize;
import lotto.domain.LottoTickets;
import lotto.util.LottoPrizeCalculator;

/**
 * @author 민경수
 * @description result ui
 * @since 2023.11.05
 **********************************************************************************************************************/
public class ResultUI {

    public void printBoughtLottos(LottoTickets lottos) {
        StringBuilder sb = new StringBuilder();

        String purchaseMsg = String.format("%d개를 구매했습니다.", lottos.size());
        sb.append(purchaseMsg).append(System.lineSeparator());

        lottos.acceptLottoNumbers((lottoNumbers) -> sb.append(lottoNumbers).append(System.lineSeparator()));

        System.out.println(sb);
    }

    public void printStatistics(Map<LottoPrize, Integer> countOfWinningRanks, LottoTickets boughtLottos) {
        StringBuilder sb = new StringBuilder();

        appendHeader(sb);
        appendStatistics(countOfWinningRanks, sb);
        appendProfitRate(countOfWinningRanks, sb, boughtLottos);

        System.out.println(sb);
    }

    private void appendProfitRate(Map<LottoPrize, Integer> countOfWinningRanks, StringBuilder sb,
                                  LottoTickets boughtLottos) {
        sb.append("총 수익률은 ").append(LottoPrizeCalculator.getProfitRate(countOfWinningRanks, boughtLottos)).append("%입니다.");
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
                winningRank.getLottoPrizeCondition().matchNumbersCount(),
                winningRank.getLottoPrizeCondition().matchBonusBall() ? ", 보너스 볼 일치" : "",
                winningRank.amount(),
                countOfWinningRanks.getOrDefault(winningRank, 0));
    }

}