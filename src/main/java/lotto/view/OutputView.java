package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoRank;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class OutputView {
    public static void outputBuyLottoCount(int buyLottoCount) {
        StringBuilder builder = new StringBuilder();
        builder.append(buyLottoCount);
        builder.append("개를 구매했습니다.");
        System.out.println(builder.toString());
    }

    public static void outputLottoNumbers(Lotto lotto) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");
        builder.append(getLottoNumbers(lotto));
        builder.append("]");
        System.out.println(builder.toString());
    }

    private static String getLottoNumbers(Lotto lotto) {
        return lotto.getLotto()
                .stream()
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }

    public static void outputAllRankMatchResults(Map<LottoRank, Integer> userLottoResultsRank) {
        System.out.println("당첨 통계");
        System.out.println("---");
        Arrays.stream(LottoRank.values())
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> outputRankMatchResult(rank, userLottoResultsRank.getOrDefault(rank, 0)));
    }

    private static void outputRankMatchResult(LottoRank rank, long winningCount) {
        String resultPrintFormat = "%d개 일치%s (%s원) - %d개";
        String bonusFormant = "";
        if(rank.getMatchBonus()) {
            bonusFormant = ", 보너스 볼 일치";
        }
        System.out.println(String.format(resultPrintFormat,
                rank.getMatchLottoCount(), bonusFormant, new DecimalFormat("###,###").format(rank.getWinnerMoney()), winningCount));
    }
}
