package lotto.view;

import java.text.DecimalFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import lotto.model.Lotto;
import lotto.model.LottoResult;

public class OutputView {

    private static final String STATISTIC_FORMAT = "%.1f";
    private static final String DECIMAL_FORMAT = "###,###";

    public static void printUserLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(changeLottoToString(lotto.getNumbers()));
        }
        System.out.println();
    }

    public static void printLottoStatistics(List<LottoResult> lottoResults, double gainStatistic) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(makeResultsToString(lottoResults));
        System.out.println("총 수익률은 " + String.format(STATISTIC_FORMAT, gainStatistic) + "%입니다.");
    }

    private static String changeLottoToString(List<Integer> numbers) {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }

    private static String makeResultsToString(List<LottoResult> userResults) {
        StringBuilder stringBuilder = new StringBuilder();
        DecimalFormat decFormat = new DecimalFormat(DECIMAL_FORMAT);

        for (LottoResult lottoResultFormat : LottoResult.values()) {
            stringBuilder.append(lottoResultFormat.getRule())
                    .append(" (" + decFormat.format(lottoResultFormat.getPrize()) + "원) - ")
                    .append(findEqualResultCount(userResults, lottoResultFormat))
                    .append("개\n");
        }

        return stringBuilder.toString();
    }

    private static long findEqualResultCount(List<LottoResult> results, LottoResult lottoResult) {
        return results.stream()
                .filter(Objects::nonNull)
                .filter(res -> res.equals(lottoResult)).count();
    }
}
