package lotto.view;

import lotto.constant.RankCategory;
import lotto.model.ProfitRate;

import java.text.DecimalFormat;
import java.util.List;
import java.util.stream.Collectors;

public class OutputFormatter {

    static void formatRankCategory(StringBuilder sb, RankCategory rankCategory, int count) {
        sb.append(rankCategory.getMatchingNumbers())
                .append("개 일치 (")
                .append(formatPrize(rankCategory.getPrize()))
                .append("원) - ")
                .append(count)
                .append("개\n");
    }

    static void formatSecondCategory(StringBuilder sb, RankCategory rankCategory, int count) {
        sb.append(rankCategory.getMatchingNumbers())
                .append("개 일치, 보너스 볼 일치 (")
                .append(formatPrize(rankCategory.getPrize()))
                .append("원) - ")
                .append(count)
                .append("개\n");
    }


    static void formatProfitRate(ProfitRate profitRate, StringBuilder sb) {
        sb.append("총 수익률은 ")
                .append(String.format("%.1f", profitRate.getRate()))
                .append("%입니다.");
    }

    private static String formatPrize(int prize) {
        DecimalFormat df = new DecimalFormat("###,###");
        return df.format(prize);
    }

    static String formatLottoNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
