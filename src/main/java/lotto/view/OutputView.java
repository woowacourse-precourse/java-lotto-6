package lotto.view;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Rank;
import lotto.dto.WinningResult;

public class OutputView {

    public void printLottoOrder(List<Lotto> lottos) {
        printLottoCount(lottos.size());
        printLottoNumbers(lottos);
    }

    private void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public void printLottoStats(WinningResult winningResult) {
        printLottoStatsHeader();
        printRankCountString(winningResult);
        printLottoProfitRate(winningResult);
    }

    private void printLottoProfitRate(WinningResult winningResult) {
        StringBuilder profitRateStringBuilder = new StringBuilder();
        profitRateStringBuilder.append("총 수익률은 ")
                .append(String.format("%.1f", winningResult.getProfitRate()))
                .append("%입니다.");
        System.out.println(profitRateStringBuilder);
    }

    private void printLottoStatsHeader() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    private void printRankCountString(WinningResult winningResult) {
        List<String> rankCountStrings = new ArrayList<>();
        winningResult.getRankCount().forEach((rank, count) -> {
            rankCountStrings.add(buildRankCountString(rank, count));
        });
        Collections.reverse(rankCountStrings);
        rankCountStrings.forEach(System.out::println);
    }

    private String buildRankCountString(Rank rank, Integer count) {
        StringBuilder sb = new StringBuilder();
        sb.append(rank.getMatchCount()).append("개 일치");
        if (rank.getMatchBonus()) {
            sb.append(", 보너스 볼 일치");
        }
        sb.append(" (")
                .append(prizeWithComma(rank.getPrize()))
                .append("원) - ")
                .append(count)
                .append("개");
        return sb.toString();
    }

    private String prizeWithComma(long prize) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(prize);
    }
}
